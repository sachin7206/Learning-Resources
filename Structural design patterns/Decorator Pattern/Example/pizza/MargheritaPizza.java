package Example.pizza;

public class MargheritaPizza implements Pizza {
    @Override
    public String getDesc() {
        return "Margherita pizza";
    }

    @Override
    public double getCost() {
        return 150;
    }
}
