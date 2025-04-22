package com.grepp.spring.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.grepp.spring.app.model.member.dto.Member;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
    "file:src/main/webapp/WEB-INF/spring/servlet-context.xml"
})
@Slf4j
public class SecurityTest {
    @Autowired
    private SecurityTestService securityTestService;
    
    @Test
    @WithMockUser(username = "test")
    public void preAuthorized(){
        Member member = new Member();
        member.setUserId("test");
        securityTestService.testPreAuthorize(member);
    }
    
    @Test
    @WithMockUser(username = "test")
    public void preAuthorized_throwEx_authorizeDenied(){
        Member member = new Member();
        member.setUserId("super");
        assertThatThrownBy(() ->securityTestService.testPreAuthorize(member))
            .isInstanceOf(AuthorizationDeniedException.class);
    }
    
    @Test
    @WithMockUser(username = "test")
    public void postAuthorized(){
        Member member = securityTestService.testPostAuthorize();
        log.info("{}" , member);
        assertThat(member)
            .extracting("userId")
            .isEqualTo("test");
    }
    
    @Test
    @WithMockUser(username = "super")
    public void postAuthorized_throwEx_authorizeDenied(){
        assertThatThrownBy(() -> securityTestService.testPostAuthorize())
            .isInstanceOf(AuthorizationDeniedException.class);
    }


    @Test
    @WithMockUser(username = "test")
    public void preFilter(){
        Member test = new Member();
        test.setUserId("test");
        Member superUser = new Member();
        superUser.setUserId("super");
        
        List<Member> members = new ArrayList<>();
        members.add(test);
        members.add(superUser);
        
        List<Member> result = securityTestService.testPreFilter(members);
        assertThat(result)
            .allSatisfy(member -> assertThat(member.getUserId()).isEqualTo("test"));
    }
    
    @Test
    @WithMockUser(username = "test")
    public void postFilter(){
        List<Member> result = securityTestService.testPostFilter();
        assertThat(result)
            .allSatisfy(member -> assertThat(member.getUserId()).isEqualTo("test"));
    }
    

}
