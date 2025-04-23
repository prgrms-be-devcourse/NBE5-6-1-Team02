package coffeemanager.app.repository;

import coffeemanager.app.model.coffee.Coffee;
import java.util.List;

public interface CoffeeRepository {
    List<Coffee> findAllCoffees();
    Coffee findCoffeeById(int coffeeId);
}