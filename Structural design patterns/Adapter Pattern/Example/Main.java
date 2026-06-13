import adapter.RazorpayAdapter;

public class Main {
    public static void main(String args[]) {
        PaymentService paymentService = new PaymentService(new RazorpayAdapter(), "1", 10.00);
        paymentService.createPayment();
        

    }
}
