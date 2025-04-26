package coffeemanager.app.controller.coffee;

import coffeemanager.app.model.coffee.CartItem;
import coffeemanager.app.model.coffee.Order;
import coffeemanager.app.model.coffee.OrderForm;
import coffeemanager.app.service.OrderService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> order(@RequestBody OrderForm request, HttpSession session) {

        List<CartItem> cartItems = request.getCart();

        if (cartItems == null || cartItems.isEmpty()) {
            return ResponseEntity.badRequest().body("장바구니가 비어 있습니다.");
        }

        Order savedOrder = orderService.processOrder(request, cartItems);
        session.setAttribute("orderEmail", request.getEmail());
        session.setAttribute("orderItems", cartItems);
        session.setAttribute("orderTime", savedOrder.getOrderDate());
        return ResponseEntity.ok().build();
    }




    @GetMapping("/coffee/order-result")
    public String orderResult(HttpSession session, Model model) {
        model.addAttribute("orderEmail", session.getAttribute("orderEmail"));
        model.addAttribute("orderItems", session.getAttribute("orderItems"));

        LocalDateTime orderDateTime = (LocalDateTime) session.getAttribute("orderTime");
        if (orderDateTime != null) {
            Date orderDate = Date.from(orderDateTime.atZone(ZoneId.systemDefault()).toInstant());
            model.addAttribute("orderTime", orderDate);

            // 배송일 계산
            int orderHour = orderDateTime.getHour();
            LocalDateTime deliveryDateTime;
            String deliveryMessage;

            if (orderHour < 14) {
                deliveryDateTime = orderDateTime; // 오늘 배송
                deliveryMessage = "당일 배송 예정";
            } else {
                deliveryDateTime = orderDateTime.plusDays(1); // 내일 배송
                deliveryMessage = "배송 예정";
            }

            // 날짜 포맷팅
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String deliveryDateStr = deliveryDateTime.format(formatter);

            // 완성 메시지
            String fullDeliveryMessage = deliveryDateStr + " " + deliveryMessage;
            model.addAttribute("deliveryMessage", fullDeliveryMessage);
        }

        return "coffee/order-result";
    }


}
