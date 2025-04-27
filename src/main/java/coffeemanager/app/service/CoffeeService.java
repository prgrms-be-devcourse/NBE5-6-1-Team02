package coffeemanager.app.service;

import coffeemanager.app.model.coffee.Coffee;
import coffeemanager.app.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAllCoffees();
    }

    public Coffee getCoffeeById(int coffeeId) {
        return coffeeRepository.findCoffeeById(coffeeId);
    }

    public void deleteCoffeeName(String coffeeName) {
        coffeeRepository.deleteCoffeeByName(coffeeName);
    }

    public void UnActive(String name){
        coffeeRepository.un_active(name);
    }

    public void ReActive(String name){
        coffeeRepository.re_active(name);
    }


}