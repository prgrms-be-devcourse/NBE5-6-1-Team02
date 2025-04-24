package coffeemanager.app.controller.web.admin;

import coffeemanager.app.controller.web.admin.form.ProductForm;
import coffeemanager.app.model.member.MemberService;
import coffeemanager.app.model.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final ProductService productService;
    
    @GetMapping("")
    public String dashboard(){
        return "admin/dashboard";
    }

    @GetMapping("/coffee/product-regist")
    public String regist(Model model) {
        model.addAttribute("ProductForm", new ProductForm());
        return "coffee/coffee-regist";
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
