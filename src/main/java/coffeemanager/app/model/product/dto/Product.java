package coffeemanager.app.model.product.dto;

import coffeemanager.app.controller.web.admin.form.ProductForm;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

    private int cpIdx;
    private String Img;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
