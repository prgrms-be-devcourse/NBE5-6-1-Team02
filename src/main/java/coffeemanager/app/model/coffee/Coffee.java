package coffeemanager.app.model.coffee;

public class Coffee {
    private int id;          // COFFEE_ID에 매핑
    private String name;     // COFFEE_NAME에 매핑
    private int price;       // PRICE에 매핑
    private String imageUrl; // 이미지 경로 (실제 DB에는 없음)

    // 기본 생성자
    public Coffee() {
        this.imageUrl = "/img/coffee-default.jpg"; // 기본 이미지 설정
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        // ID가 설정될 때 해당 ID에 맞는 이미지 URL 설정
        this.imageUrl = "/img/coffee/" + id + ".jpg";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}