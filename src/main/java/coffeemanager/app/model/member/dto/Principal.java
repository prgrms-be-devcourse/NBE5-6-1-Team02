package coffeemanager.app.model.member.dto;

import coffeemanager.app.model.auth.code.Role;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.type.Alias;

@Alias("MEMBER_PRINCIPAL")
public record Principal(
    String email,
    List<Role> Roles,
    LocalDateTime loginedAt
){

}
