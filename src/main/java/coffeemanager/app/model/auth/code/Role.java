package coffeemanager.app.model.auth.code;

import org.apache.ibatis.type.Alias;

@Alias("MEMBER_ROLE")
public enum Role {
    ROLE_USER,
    ROLE_ADMIN
}
