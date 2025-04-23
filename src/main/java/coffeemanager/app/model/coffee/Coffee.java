package coffeemanager.app.model.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Coffee {
    private int id;          // COFFEE_ID에 매핑
    private String name;     // COFFEE_NAME에 매핑
    private int price;       // PRICE에 매핑
    private String type;
    private String imageUrl; // 이미지 경로 (실제 DB에는 없음)
}