//package coffeemanager.security;
//
//import coffeemanager.app.model.member.dto.Member;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PostFilter;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreFilter;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class SecurityTestService {
//
//    @PreAuthorize("authentication.name == #member.userId")
//    public void testPreAuthorize(Member member){
//        log.info("인증된 사용자 입니다.");
//    }
//
//    // returnObject : 메서드가 반환하는 객체
//    @PostAuthorize("returnObject.userId == authentication.name")
//    public Member testPostAuthorize(){
//        Member member = new Member();
//        member.setEmail("test@aaa.aaa");
//        return member;
//    }
//
//    @PreFilter(filterTarget = "members", value = "authentication.name == filterObject.email")
//    public List<Member> testPreFilter(List<Member> members){
//        log.info("members : {}", members);
//        return members;
//    }
//
//    @PostFilter("authentication.name == filterObject.userId")
//    public List<Member> testPostFilter(){
//        Member test = new Member();
//        test.setEmail("test@aaa.aaa");
//
//        Member superUser = new Member();
//        superUser.setEmail("admin@aaa.aaa");
//
//        return List.of(test, superUser);
//    }
//
//}
