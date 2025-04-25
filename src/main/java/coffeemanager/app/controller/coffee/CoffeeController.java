package coffeemanager.app.controller.coffee;

import coffeemanager.app.model.coffee.Coffee;
import coffeemanager.app.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping("/coffee/order")
    public String coffeeList(Model model, HttpSession session) {
        // 상품 목록 가져오기
        List<Coffee> coffeeList = coffeeService.getAllCoffees();
        model.addAttribute("products", coffeeList);

        // 세션에서 비회원 이메일 확인
        String guestEmail = (String) session.getAttribute("guestEmail");
        if (guestEmail != null && !guestEmail.isEmpty()) {
            model.addAttribute("guestEmail", guestEmail);
        }

        return "coffee/order";
    }

    @GetMapping("/coffee/member-order")
    public String memberOrder(Model model, HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";

        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        } else {
            email = principal.toString();
        }

        // 상품 목록 가져오기
        List<Coffee> coffeeList = coffeeService.getAllCoffees();
        model.addAttribute("products", coffeeList);

        // 사용자 이메일 추가
        model.addAttribute("userEmail", email);

        return "coffee/member-order";
    }
}