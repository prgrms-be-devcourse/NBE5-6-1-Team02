package coffeemanager.app.controller.member;


import coffeemanager.app.controller.member.form.DeleteForm;
import coffeemanager.app.controller.member.form.SigninForm;
import coffeemanager.app.controller.member.form.SignupForm;
import coffeemanager.app.controller.member.form.UpdateForm;
import coffeemanager.app.model.member.MemberService;
import coffeemanager.app.model.member.dto.Member;
import coffeemanager.app.model.member.dto.Principal;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signup(SignupForm form){
        return "member/signup";
    }

    @GetMapping("/fixinfo")
    public String fixinfo(Model model){
        model.addAttribute("updateForm", new UpdateForm());
        return "member/fixinfo";
    }

    @PostMapping("fixinfo")
    public String fixInfo(
        @Valid UpdateForm form,
        BindingResult bindingResult,
        Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "member/fixinfo";
        }

        form.setEmail(authentication.getName());
        memberService.update(form);

        return "redirect:/member/mypage";
    }


    @PostMapping("signup")
    public String signup(
        @Valid SignupForm form,
        BindingResult bindingResult,
        Model model) {

        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        if(memberService.isDuplicatedId(form.getEmail())){
            bindingResult.rejectValue("email", "duplicated", "이미 가입된 이메일입니다.");
            return "member/signup";
        }

        memberService.signup(form.toDto());

        return "redirect:/";
    }

    @GetMapping("mypage")
    public String mypage(Authentication authentication, Model model){
        log.info("authentication : {}", authentication);
        String email = authentication.getName();
        Member member = memberService.findByEmail(email);
        model.addAttribute("member", member);
        return "member/mypage";
    }

    @PostMapping("/guest-order")
    public String processGuest(@RequestParam("email") String email, HttpSession session) {

        // 비회원 이메일을 세션에 저장
        session.setAttribute("guestEmail", email);

        // 일반 주문 페이지로 리다이렉트
        return "redirect:/coffee/order";
    }

    @GetMapping("member-delete")
    public String delete(Authentication authentication, Model model) {
        model.addAttribute("deleteForm", new DeleteForm());
        return "member/member-delete";
    }


    @DeleteMapping("/{email}")
    public String memberDelete(@PathVariable("email") String email,
        @RequestParam("password") String password,
        HttpSession session,
        RedirectAttributes redirectAttributes) {
        try {
            memberService.delete(email,password);
            return "redirect:/";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/member/delete";
        }
    }

    @PostMapping("/delete")
    public String memberDelete(
        Authentication authentication,
        @ModelAttribute("deleteForm") DeleteForm form,
        RedirectAttributes redirectAttributes
    ) {
        try {
            String email = authentication.getName();
            memberService.delete(email, form.getPassword());
            redirectAttributes.addFlashAttribute("successMessage", "탈퇴 처리되었습니다.");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/member/member-delete";
        }
    }
}

