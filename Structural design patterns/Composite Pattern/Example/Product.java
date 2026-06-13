package Example;

public class Product implements CartItem {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public int getPrice() {
        return price;
    }

}
