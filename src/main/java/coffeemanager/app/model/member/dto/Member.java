package coffeemanager.app.model.member.dto;

import coffeemanager.app.model.auth.code.Role;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class Member {
    
    private String userEmail;
    private String password;
//    private Role role;
    private String tel;
    private String address;
    private String zipcode;
    private Boolean activated;
}
