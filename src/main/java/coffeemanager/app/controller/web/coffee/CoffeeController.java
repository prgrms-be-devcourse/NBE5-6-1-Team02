package coffeemanager.app.controller.web.coffee;

import coffeemanager.app.model.coffee.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffee")
    public String coffees(Model model) {
        model.addAttribute("coffees", coffeeService.getAllProducts());
        model.addAttribute("cartItems", coffeeService.getCartItems());
        model.addAttribute("totalPrice", coffeeService.calculateTotal());
        return "coffee/order"; // JSP 경로와 매칭 (view resolver가 처리)
    }

    @PostMapping("/order")
    public String order(OrderForm orderForm, RedirectAttributes redirectAttributes) {
        coffeeService.processOrder(orderForm);
        redirectAttributes.addFlashAttribute("success", "주문 완료");
        return "redirect:/coffee";
    }
}
