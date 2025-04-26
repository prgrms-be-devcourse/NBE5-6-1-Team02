package coffeemanager.app.service;

import coffeemanager.app.model.coffee.CartItem;
import coffeemanager.app.model.coffee.Order;
import coffeemanager.app.model.coffee.OrderForm;
import coffeemanager.app.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public Order processOrder(OrderForm form, List<CartItem> cartItems) {
        int totalPrice = cartItems.stream()
            .mapToInt(item -> item.getPrice() * item.getQuantity())
            .sum();

        // 1. 주문 정보 저장
        Order order = new Order();
        order.setEmail(form.getEmail());
        order.setAddress(form.getAddress());
        order.setPostcode(form.getPostcode());
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);

        orderRepository.insertOrder(order); // useGeneratedKeys=true 로 ID 생성됨

        // 2. 주문 커피 정보 저장
        for (CartItem item : cartItems) {
            orderRepository.insertOrderCoffee(order.getId(), item.getCoffeeId(),
                item.getName(), item.getQuantity());
        }

        return order;
    }
}
