package coffeemanager.app.model.auth;

import coffeemanager.app.model.auth.domain.Principal;
import coffeemanager.app.model.member.MemberRepository;
import coffeemanager.app.model.member.dto.Member;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements UserDetailsService {
    
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username){

        Member member = memberRepository.selectByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException(username));
        
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(member.getRole().name()));

        log.info("member.getEmail(): {}", member.getEmail());
        log.info("member.getPassword(): {}", member.getPassword());
        log.info("authorities: {}", authorities);

        // 스프링시큐리티는 기본적으로 권한 앞에 ROLE_ 이 있음을 가정
        // hasRole("ADMIN") =>  ROLE_ADMIN 권한이 있는 지 확인.
        // TEAM_{teamId}:{role}
        // hasAuthority("ADMIN") => ADMIN 권한을 확인

        return Principal.createPrincipal(member, authorities);
    }
    
    
}
