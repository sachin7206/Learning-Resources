package Example.decorator;

import Example.pizza.Pizza;

public class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDesc() {
        return pizza.getDesc() + ", with Extra cheese";
    }

    @Override
    public double getCost() {
       return pizza.getCost() + 20;
    }
}
