package coffeemanager.app.controller.web.member;


import coffeemanager.app.controller.web.member.form.SigninForm;
import coffeemanager.app.controller.web.member.form.SignupForm;
import coffeemanager.app.model.member.MemberService;
import coffeemanager.app.model.member.dto.Principal;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지 GET
    @GetMapping("/member-login")
    public String login(SigninForm form){
        return "member/member-login";
    }

    // 비회원 로그인 페이지 GET
    @GetMapping("/guest-login")
    public String noUserLogin(){return "member/guest-login";}

    @GetMapping("/mypage")
    public String myPage(Model model){
        return "member/mypage";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signup(SignupForm form){
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(
        @Valid SignupForm form,
        BindingResult bindingResult,
        Model model) {

        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        memberService.signup(form.toDto());

        return "redirect:/";
    }
}

