package coffeemanager.app.controller.member.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeleteForm {
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;

}
