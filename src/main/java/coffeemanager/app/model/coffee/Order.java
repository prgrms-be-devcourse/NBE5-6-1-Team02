package coffeemanager.app.model.coffee;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

    private Long id;
    private String email;
    private String address;
    private String postcode;
    private int totalPrice;
    private LocalDateTime orderDate;

}
