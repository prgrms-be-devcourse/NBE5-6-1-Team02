package coffeemanager.app.model.coffee;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Coffee {
    private int id;          // COFFEE_ID에 매핑
    private String name;     // COFFEE_NAME에 매핑
    private int price;       // PRICE에 매핑
    private String type;
    private List<ProductImg> images;
    private String imageUrl; // 이미지 경로 (실제 DB에는 없음)

    public String getThumbnailUrl() {
        if (images != null && !images.isEmpty()) {
            return images.get(0).getUrl(); // 첫 번째 이미지를 썸네일로 사용
        }
        return "/assets/img/default.png"; // 이미지가 없는 경우 기본 이미지
    }

}