package coffeemanager.app.model.member.dto;

import coffeemanager.app.model.auth.code.Role;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Member")
public class Member {
    
    private String userId;
    private String password;
    private String email;
    private Role role;
    private String tel;
    private MemberInfo info;
    private Boolean activated;
}
