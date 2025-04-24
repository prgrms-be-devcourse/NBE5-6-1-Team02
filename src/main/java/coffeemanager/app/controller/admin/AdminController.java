package coffeemanager.app.controller.admin;

import coffeemanager.app.controller.admin.form.ProductForm;
import coffeemanager.app.model.coffee.Coffee;
import coffeemanager.app.model.product.ProductService;
import coffeemanager.app.service.CoffeeService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final ProductService productService;
    private final CoffeeService coffeeService;
    
    @GetMapping()
    public String dashboard() {

        return "admin/dashboard";
    }

    @GetMapping("/coffee/product-regist")
    public String regist(Model model) {
        model.addAttribute("ProductForm", new ProductForm());
        return "coffee/coffee-regist";
    }

    @GetMapping("product-list")
    public String productList(Model model) {
        List<Coffee> coffees = coffeeService.getAllCoffees();
        model.addAttribute("coffees", coffees);
        return "admin/product-list";
    }

    @PostMapping("product/delete")
    public String deleteProduct(@RequestParam String coffeeName){
        coffeeService.deleteCoffeeName(coffeeName);

        return "redirect:/admin/product-list";
    }

    @PostMapping("/regist")
    public String regist(@Valid ProductForm form, BindingResult bindingResult
        ,Model model){

        if(bindingResult.hasErrors()){
            return "coffee/coffee-regist";
        }

        productService.registProduct(form.getPd_Img(), form.toDto());
        return "redirect:/admin";
    }



    

}
