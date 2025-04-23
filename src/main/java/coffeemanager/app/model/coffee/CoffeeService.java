package coffeemanager.app.model.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }

    public List<CartItem> getCartItems(){

    }

}
