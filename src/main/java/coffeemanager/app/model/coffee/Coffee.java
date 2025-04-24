package coffeemanager.app.model.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Coffee {
    private Integer cpIdx;
    private String Img;// COFFEE_ID에 매핑
    private String name;     // COFFEE_NAME에 매핑
    private int price;       // PRICE에 매핑

}