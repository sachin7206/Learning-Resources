package invoice;

public class StandardInvoice implements Invoice {
    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating Standard Invoice for amount: " + amount);
    }
}
