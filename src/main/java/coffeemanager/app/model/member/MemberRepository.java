package coffeemanager.app.model.member;

import coffeemanager.app.model.member.dto.Member;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRepository {

    Optional<Member> selectById(String userId);
    
    @Select("select count(*) from member where user_id = #{userId}")
    Boolean existsMember(String userId);
    
    @Insert("insert into member (USER_Email, PASSWORD, TEL, ADDRESS,ZIPCODE) "
                + "values(#{email}, #{password},#{tel},#{address},#{zipcode})")
    void insert(Member dto);

}
