public class RajorPayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying via Rajor Pay payment amount : " + amount);
    }
}
