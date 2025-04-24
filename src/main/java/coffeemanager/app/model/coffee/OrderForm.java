package coffeemanager.app.model.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {
    private String email;
    private String address;
    private String postcode;

}
