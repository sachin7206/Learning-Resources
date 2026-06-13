package PaymentGateway;

// Target Interface: 
// Standard interface expected by the 
public interface Payment {
    void pay(String orderId, double amount);
}
