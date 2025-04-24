package coffeemanager.app.controller.web.admin.form;


import coffeemanager.app.model.product.dto.Product;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductForm {

    private String pd_Img;
    @NotBlank
    private String name;
    @NotBlank
    private int price;

    public Product toDto(){
        Product product = new Product();
        product.setImg(pd_Img);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
