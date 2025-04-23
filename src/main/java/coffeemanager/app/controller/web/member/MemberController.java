package coffeemanager.app.controller.web.member;


import coffeemanager.app.model.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지
    @GetMapping("/member-login")
    public String login(){
        return "member/member-login";
    }

    @GetMapping("/guest-login")
    public String noUserLogin(){return "member/guest-login";}

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signup(){
        return "member/signup";
    }

    // 다시 로그인 페이지
    @GetMapping("/redirect-login")
    public String redirectLogin(){
        return "member/member-login";
    }

//    @PostMapping("signin")
//    public String signin(
//        @Valid SigninForm form,
//        BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//            return "member/signin";
//        }


}

