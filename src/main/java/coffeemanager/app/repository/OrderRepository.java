package coffeemanager.app.repository;

import coffeemanager.app.model.coffee.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderRepository {
    void insertOrder(Order order);

    void insertOrderCoffee(@Param("orderId") Long orderId,
        @Param("coffeeId") Long coffeeId,
        @Param("coffeeName") String coffeeName,
        @Param("quantity") int quantity);
}
