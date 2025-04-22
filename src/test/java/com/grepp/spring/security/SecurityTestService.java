package com.grepp.spring.security;

import com.grepp.spring.app.model.member.dto.Member;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityTestService {
    
    @PreAuthorize("authentication.name == #member.userId")
    public void testPreAuthorize(Member member){
        log.info("인증된 사용자 입니다.");
    }
    
    // returnObject : 메서드가 반환하는 객체
    @PostAuthorize("returnObject.userId == authentication.name")
    public Member testPostAuthorize(){
        Member member = new Member();
        member.setUserId("test");
        return member;
    }
    
    @PreFilter(filterTarget = "members", value = "authentication.name == filterObject.userId")
    public List<Member> testPreFilter(List<Member> members){
        log.info("members : {}", members);
        return members;
    }
    
    @PostFilter("authentication.name == filterObject.userId")
    public List<Member> testPostFilter(){
        Member test = new Member();
        test.setUserId("test");
        
        Member superUser = new Member();
        superUser.setUserId("super");
        
        return List.of(test, superUser);
    }

}
