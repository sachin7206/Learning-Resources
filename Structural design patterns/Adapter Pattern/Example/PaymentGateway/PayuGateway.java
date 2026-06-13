package PaymentGateway;

public class PayuGateway implements Payment {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("paying amount = " + amount + " with payugateway for " + orderId);
    }
}
