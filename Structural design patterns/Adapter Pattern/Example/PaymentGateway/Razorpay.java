package PaymentGateway;

// Adaptee: 
// An existing class with an incompatible interface
public class Razorpay {
    public void makePayment(String invoiceId, double amountInRupees) {
        System.out.println("Paid Rs." + amountInRupees + " using Razorpay for invoice: " + invoiceId);
    }
}
