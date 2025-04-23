package coffeemanager.app.controller.coffee;

import coffeemanager.app.model.coffee.CartItem;
import coffeemanager.app.model.coffee.OrderForm;
import coffeemanager.app.service.OrderService;
import jakarta.servlet.http.HttpSession;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/order")
    public String order(@ModelAttribute OrderForm form, HttpSession session,
        RedirectAttributes redirectAttributes) {
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "장바구니가 비어 있습니다.");
            return "redirect:/coffee/list";
        }

        orderService.processOrder(form, cart);

        session.removeAttribute("cart"); // 장바구니 비움
        redirectAttributes.addFlashAttribute("message", "주문이 완료되었습니다!");
        return "redirect:/coffee/list";
    }
}
