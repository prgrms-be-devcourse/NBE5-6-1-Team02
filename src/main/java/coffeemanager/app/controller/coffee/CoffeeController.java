package coffeemanager.app.controller.coffee;

import coffeemanager.app.model.coffee.CartItem;
import coffeemanager.app.model.coffee.Coffee;
import coffeemanager.app.service.CoffeeService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping("/coffee/order")
    public String coffeeList(Model model, HttpSession session) {
        List<Coffee> coffeeList = coffeeService.getAllCoffees();
        model.addAttribute("products", coffeeList);

        return "coffee/order";
    }

    @GetMapping("/cart/add")
    @ResponseBody
    public String addToCart(@RequestParam("id") Long coffeeId, HttpSession session) {

        Coffee coffee = coffeeService.getCoffeeById(coffeeId.intValue());
        if (coffee == null) {
            return "fail";
        }

        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        if (cart.containsKey(coffeeId)) {
            CartItem existingItem = cart.get(coffeeId);
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {
            CartItem item = new CartItem();
            item.setCoffeeId(coffeeId);
            item.setName(coffee.getName());
            item.setPrice(coffee.getPrice());
            item.setQuantity(1);
            cart.put(coffeeId, item);
        }

        session.setAttribute("cart", cart);
        return "success";
    }

    @GetMapping("/cart/data")
    @ResponseBody
    public Map<String, Object> getCartData(HttpSession session) {
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        Map<String, Object> result = new HashMap<>();

        if (cart != null) {
            result.put("cartItems", cart.values());

            int totalPrice = cart.values().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
            result.put("totalPrice", totalPrice);
        } else {
            result.put("cartItems", Collections.emptyList());
            result.put("totalPrice", 0);
        }

        return result;
    }

    @GetMapping("/cart/remove")
    @ResponseBody
    public String removeFromCart(@RequestParam("id") Long coffeeId, HttpSession session) {
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(coffeeId)) {
            cart.remove(coffeeId);
            session.setAttribute("cart", cart);
            return "success";
        }
        return "fail";
    }

    @GetMapping("/coffee/member-order")
    public String memberOrder(Model model, HttpSession session) {
        // 회원인지 확인 (실제 로그인 기능 구현 시 이 부분은 인터셉터나 필터로 대체 가능)
        // 지금은 더미 데이터 사용

        // 상품 목록 가져오기 (기존 로직과 동일)
        List<Coffee> coffeeList = coffeeService.getAllCoffees();
        model.addAttribute("products", coffeeList);

        // 회원 이메일을 모델에 추가 (실제 로그인 기능 구현 시 세션에서 가져옴)
        model.addAttribute("memberEmail", "aaa@naver.com");

        return "coffee/member-order";
    }

}