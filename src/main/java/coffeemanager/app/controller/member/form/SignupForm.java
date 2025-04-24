package coffeemanager.app.controller.member.form;

import coffeemanager.app.model.member.dto.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 10)
    private String password;

    @NotBlank
    @Size(min = 8, max = 14)
    private String tel;

    @NotBlank
    private String address;

    @NotBlank
    private String zipCode;
    
    public Member toDto(){
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setTel(tel);
        member.setAddress(address);
        member.setZipcode(zipCode);
        member.setActivated(true);
        return member;
    }
}
