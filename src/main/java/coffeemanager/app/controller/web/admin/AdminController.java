package coffeemanager.app.controller.web.admin;


import coffeemanager.app.model.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    private final MemberService memberService;
    
    @GetMapping
    public String dashboard(){
        return "admin/dashboard";
    }
    

}
