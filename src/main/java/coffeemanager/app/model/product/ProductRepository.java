package coffeemanager.app.model.product;

import coffeemanager.app.model.product.dto.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductRepository {

    @Insert("insert into coffee(COFFEE_IMG, COFFEE_NAME, PRICE) "
        + "values (#{Img},#{name},#{price})")
    @Options(useGeneratedKeys = true, keyColumn = "COFFEE_ID", keyProperty = "cpIdx")
    void insert(Product product);

    @Select("select COFFEE_IMG from COFFEE WHERE COFFEE_NAME = #{name}")
    void findByImage(String name);

}
