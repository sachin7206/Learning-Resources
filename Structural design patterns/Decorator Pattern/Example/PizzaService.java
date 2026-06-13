package Example;

import Example.decorator.ExtraCheese;
import Example.decorator.Olive;
import Example.pizza.Pizza;

public class PizzaService {

    public void getDetailsOfPizzaWithExtraCheese(Pizza pizza) {
        pizza = new ExtraCheese(pizza);
        printDetails(pizza);
    }

    public void getDetailsOfPizzaWithOlive(Pizza pizza) {
        pizza = new Olive(pizza);
        printDetails(pizza);
    }

    private void printDetails(Pizza pizza) {
        System.out.println(pizza.getCost());
        System.out.println(pizza.getDesc());
    }

    
}
