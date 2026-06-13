package invoice;

public class ProformaInvoice implements Invoice {
    @Override
    public void generateInvoice(double amount) {
        System.out.println("Generating Proforma Invoice for amount: " + amount);
    }
}
