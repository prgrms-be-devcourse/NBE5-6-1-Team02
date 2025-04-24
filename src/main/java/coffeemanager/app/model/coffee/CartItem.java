package coffeemanager.app.model.coffee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItem {

    private Long coffeeId;
    private String name;
    private int quantity;
    private int price;

}
