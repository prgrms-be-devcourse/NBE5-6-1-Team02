package coffeemanager.app.model.coffee;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {
    private String email;
    private String address;
    private String postcode;
    private List<CartItem> cart;

}
