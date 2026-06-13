package Example;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements CartItem {
    private String name;
    private List<CartItem> productList = new ArrayList<>();

    public ProductBundle(String name) {
        this.name = name;
    }

    public void addItem(CartItem product) {
        this.productList.add(product);
    }

    @Override
    public void display() {
        System.out.println("Bundle: " + name);
        for (CartItem item : productList) {
            item.display();
        }
    }

    @Override
    public int getPrice() {
        int total = 0;
        for(CartItem cartItem : productList) {
            total += cartItem.getPrice();
        }
        return total;
    }
}
