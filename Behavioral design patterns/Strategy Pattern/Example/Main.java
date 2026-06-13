public class Main {
    public static void main(String[] args) {
        PaymentDriver paymentDriver = new PaymentDriver(new RajorPayStrategy());
        paymentDriver.pay(100);

        paymentDriver.setPaymentStrategy(new PayUStrategy());
        paymentDriver.pay(200);


    }

}
