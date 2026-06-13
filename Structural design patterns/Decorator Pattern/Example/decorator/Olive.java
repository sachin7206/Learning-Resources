package Example.decorator;

import Example.pizza.Pizza;

public class Olive extends PizzaDecorator{
    public Olive(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDesc() {
        return pizza.getDesc() + ", with Olive";
    }

    @Override
    public double getCost() {
       return pizza.getCost() + 40;
    }
    
}
