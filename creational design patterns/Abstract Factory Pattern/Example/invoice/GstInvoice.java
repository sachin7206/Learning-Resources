package invoice;

public class GstInvoice implements Invoice {

    @Override
    public void generateInvoice(double amount) {
        double gstAmount = amount * 0.18; // Assuming GST is 18%
        double totalAmount = amount + gstAmount;
        System.out.println("Generating GST Invoice:");
        System.out.println("Base Amount: $" + amount);
        System.out.println("GST (18%): $" + gstAmount);
        System.out.println("Total Amount: $" + totalAmount);
    }

}
