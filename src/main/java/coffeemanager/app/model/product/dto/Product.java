package coffeemanager.app.model.product.dto;

import coffeemanager.app.controller.web.admin.form.ProductForm;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class Product {

    private Integer cpIdx;
    private String Img;
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
