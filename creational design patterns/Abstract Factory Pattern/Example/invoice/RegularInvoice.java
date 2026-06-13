package invoice;

public class RegularInvoice implements Invoice {
    @Override
    public void generateInvoice(double amount) {
        double tax = amount * 0.18; // Assuming 18% tax for normal invoice
        double totalAmount = amount + tax;
        System.out.println("Normal Tax Invoice Generated:");
        System.out.println("Amount: " + amount);
        System.out.println("Tax: " + tax);
        System.out.println("Total Amount: " + totalAmount);
    }
}
