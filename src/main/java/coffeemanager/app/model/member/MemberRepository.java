package coffeemanager.app.model.member;

import coffeemanager.app.controller.member.form.UpdateForm;
import coffeemanager.app.model.member.dto.Member;
import java.util.Optional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
@Repository
public interface MemberRepository {

    Optional<Member> selectByEmail(String email);

    @Select("select USER_Email as email, password from member where USER_Email = #{email}")
    Optional<Member> findByEmail(@Param("email") String email);
    
    @Select("select count(*) from member where USER_Email = #{email}")
    Boolean existsMember(String email);
    
    @Insert("insert into member (USER_Email, PASSWORD, TEL, ADDRESS,ZIPCODE) "
                + "values(#{email}, #{password},#{tel},#{address},#{zipcode})")
    void insert(Member dto);

    @Update("update member "
        + "set PASSWORD = #{password}, TEL = #{tel}, ADDRESS = #{address}, ZIPCODE = #{zipCode}"
        + "where USER_Email = #{email}")
    void update(UpdateForm dto);

    @Delete("delete from member where USER_Email = #{email}")
    void delete(@Param("email") String email);
}
