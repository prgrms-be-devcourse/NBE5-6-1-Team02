package coffeemanager.app.model.member;

import coffeemanager.app.controller.member.form.UpdateForm;
import coffeemanager.app.model.member.dto.Member;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRepository {

    Optional<Member> selectByEmail(String email);
    
    @Select("select count(*) from member where USER_Email = #{email}")
    Boolean existsMember(String email);
    
    @Insert("insert into member (USER_Email, PASSWORD, TEL, ADDRESS,ZIPCODE) "
                + "values(#{email}, #{password},#{tel},#{address},#{zipcode})")
    void insert(Member dto);

    @Update("update member "
        + "set PASSWORD = #{password}, TEL = #{tel}, ADDRESS = #{address}, ZIPCODE = #{zipCode}"
        + "where USER_Email = #{email}")
    void update(UpdateForm dto);

}
