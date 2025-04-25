package coffeemanager.infra.config;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import coffeemanager.app.model.auth.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = "coffeemanager")
public class SecurityConfig {

    @Value("${remember-me.key}")
    private String rememberMeKey;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .build();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request,
                HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {

                boolean isAdmin = authentication.getAuthorities()
                    .stream()
                    .anyMatch(authority ->
                        authority.getAuthority().equals("ROLE_ADMIN"));

                if(isAdmin){
                    response.sendRedirect("/admin");
                    return;
                }

                response.sendRedirect("/member/mypage");
            }
        };

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthService authService) throws Exception {

        http
            .authorizeHttpRequests(
                (requests) -> requests
                    .requestMatchers(GET, "/", "/assets/**", "/download/**").permitAll()
                    .requestMatchers(GET, "/book/list").permitAll()
                    .requestMatchers(GET, "/api/book/list").permitAll()
                    .requestMatchers(GET, "/api/member/exists/*").permitAll()
                    .requestMatchers(GET, "/member/signup").permitAll()
                    .requestMatchers(GET, "/admin/**").permitAll()
                    .requestMatchers(GET, "/member/guest-login").permitAll()
                    .requestMatchers(GET, "/coffee/order").permitAll()
                    .requestMatchers(GET, "/order").permitAll()
                    .requestMatchers(GET, "/member/member-login").permitAll()
                    .requestMatchers(POST, "/member/member-login", "/member/signup").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/member/member-login")
                .usernameParameter("email")
                .loginProcessingUrl("/member/member-login")
                .defaultSuccessUrl("/")
                .successHandler(successHandler())
                .permitAll()
            )
            .rememberMe(rememberMe -> rememberMe.key(rememberMeKey)
                .tokenValiditySeconds(60*60*24*7)
                .userDetailsService(authService))
            .logout(LogoutConfigurer::permitAll);
        
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
