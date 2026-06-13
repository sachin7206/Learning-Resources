package Example.pizza;

public class PlainPizza implements Pizza {
    @Override
    public String getDesc() {
        return "Plain pizza";
    }

    @Override
    public double getCost() {
        return 100;
    }
}
