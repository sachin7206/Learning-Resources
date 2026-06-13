public class PayUStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying via payU payment amount : " + amount);
    }
}
