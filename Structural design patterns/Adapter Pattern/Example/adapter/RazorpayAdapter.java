package adapter;
// Adapter Class:
// Allows Razorpay to be used where PaymentGateway is expected

import PaymentGateway.Payment;
import PaymentGateway.Razorpay;

public class RazorpayAdapter implements Payment {

    private Razorpay razorpay;
    
    public RazorpayAdapter() {
        this.razorpay = new Razorpay();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorpay.makePayment(orderId, amount);
    }
}
