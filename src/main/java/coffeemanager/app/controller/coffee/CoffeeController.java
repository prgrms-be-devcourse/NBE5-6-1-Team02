package coffeemanager.app.controller.coffee;

import coffeemanager.app.model.coffee.CartItem;
import coffeemanager.app.model.coffee.Coffee;
import coffeemanager.app.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        // 장바구니 정보가 있으면 모델에 추가
        @SuppressWarnings("unchecked") // 강제 형변환 문제 발생 시 조치 예정
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
            model.addAttribute("cartItems", cart.values());

            // 총 금액 계산
            int totalPrice = cart.values().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
            model.addAttribute("totalPrice", totalPrice);
        }

        return "coffee/order"; // coffee 디렉토리의 list.jsp를 찾음
    }

    @GetMapping("/cart/add") // postMapping 과 연결되는지 확인 필요
    public String addToCart(@RequestParam("id") Long coffeeId,
        HttpSession session,
        RedirectAttributes redirectAttributes) {
        // 데이터베이스에서 커피 정보 조회
        Coffee coffee = coffeeService.getCoffeeById(coffeeId.intValue());

        if (coffee == null) {
            redirectAttributes.addFlashAttribute("error", "상품을 찾을 수 없습니다.");
            return "redirect:/coffee/order";
        }

        // 세션에서 장바구니 가져오기
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");

        // 장바구니가 없으면 새로 생성
        if (cart == null) {
            cart = new HashMap<>();
        }

        // 이미 장바구니에 있는 상품이면 수량 증가
        if (cart.containsKey(coffeeId)) {
            CartItem existingItem = cart.get(coffeeId);
            existingItem.setQuantity(existingItem.getQuantity() + 1);
        } else {
            // 새 상품이면 장바구니에 추가
            CartItem newItem = new CartItem();
            newItem.setCoffeeId(coffeeId);
            newItem.setName(coffee.getName());
            newItem.setPrice(coffee.getPrice());
            newItem.setQuantity(1);
            cart.put(coffeeId, newItem);
        }

        // 세션에 장바구니 저장
        session.setAttribute("cart", cart);

        redirectAttributes.addFlashAttribute("message", coffee.getName() + "이(가) 장바구니에 추가되었습니다.");
        return "redirect:/coffee/order";
    }
/*
    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        // 장바구니 정보 가져오기
        Map<Long, CartItem> cart = (Map<Long, CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "장바구니가 비어 있습니다.");
            return "redirect:/coffee/list";
        }

        // 상품 목록 가져오기
        List<Coffee> coffeeList = coffeeService.getAllCoffees();

        // 모델에 데이터 추가
        model.addAttribute("products", coffeeList);
        model.addAttribute("cartItems", cart.values());

        // 총 금액 계산
        int totalPrice = cart.values().stream()
            .mapToInt(item -> item.getPrice() * item.getQuantity())
            .sum();
        model.addAttribute("totalPrice", totalPrice);

        return "order/order"; // order 디렉토리의 order.jsp를 찾음
    }*/
}