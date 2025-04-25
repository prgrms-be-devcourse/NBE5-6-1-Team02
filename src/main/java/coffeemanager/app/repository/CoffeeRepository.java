package coffeemanager.app.repository;

import coffeemanager.app.model.coffee.Coffee;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CoffeeRepository {
    List<Coffee> findAllCoffees();
    Coffee findCoffeeById(int coffeeId);

    @Delete("delete from coffee where coffee_name = #{coffeeName}")
    void deleteCoffeeByName(String coffeeName);
}