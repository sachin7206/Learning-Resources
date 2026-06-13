package Example;

import Example.pizza.MargheritaPizza;

public class Main {
    public static void main(String args[]) {
        PizzaService pizzaService = new PizzaService();
        pizzaService.getDetailsOfPizzaWithOlive(new MargheritaPizza());
    }
}
