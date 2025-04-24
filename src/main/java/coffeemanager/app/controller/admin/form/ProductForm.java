package coffeemanager.app.controller.admin.form;


import coffeemanager.app.model.product.dto.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductForm {

    private MultipartFile pd_Img;
    @NotBlank
    private String name;
    private int price;

    public Product toDto(){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
