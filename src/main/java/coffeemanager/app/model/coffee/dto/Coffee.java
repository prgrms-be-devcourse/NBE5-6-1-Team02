package coffeemanager.app.model.coffee.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
public class Coffee {

    private Long id;
    private String name;
    private String type;
    private String image;
    private int price;

}
