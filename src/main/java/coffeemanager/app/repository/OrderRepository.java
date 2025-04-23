package coffeemanager.app.repository;

import coffeemanager.app.model.coffee.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderRepository {
    void insertOrder(Order order);

    void insertOrderCoffee(@Param("orderId") Long orderId,
        @Param("coffeeId") Long coffeeId,
        @Param("quantity") int quantity);
}
