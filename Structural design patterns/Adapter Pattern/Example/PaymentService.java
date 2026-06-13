import PaymentGateway.Payment;

public class PaymentService {
    private Payment payment;
    private String orderId;
    private double amount;
    public PaymentService(Payment payment, String orderId, double amount) {
        this.payment = payment;
        this.orderId = orderId;
        this.amount = amount;
    }

    public void createPayment() {
        payment.pay(orderId, amount);
    }
   
    
}
