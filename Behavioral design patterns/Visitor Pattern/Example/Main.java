import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String agrs[]) {
        List<Item> items = new ArrayList<>();
        Item digitalProduct = new DigitalProduct("DigitalProductName", 10);
        Item physicalProduct = new PhysicalProduct("PhysicalProductName", 100);
        Item giftCard = new GiftCard("GiftCardCode", 1000.00);
        items.add(digitalProduct);
        items.add(physicalProduct);
        items.add(giftCard);

        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for (Item item : items) {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);

            System.out.println("");
        }



    }
}
