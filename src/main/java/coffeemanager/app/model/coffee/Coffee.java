package coffeemanager.app.model.coffee;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Coffee {
    private Integer cpIdx;
    private String img;//
    private String name;     // COFFEE_NAME에 매핑
    private int price;       // PRICE에 매핑
    private int active;
}