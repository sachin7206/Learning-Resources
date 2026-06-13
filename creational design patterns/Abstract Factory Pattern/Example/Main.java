import abstractFactory.IndiaFactory;

public class Main {
    public static void main(String[] args) {
        CheckOutService checkOutService = new CheckOutService(new IndiaFactory(), "Cashfree", "GstInvoice", 100.0);
        checkOutService.checkOut();
    }
}
