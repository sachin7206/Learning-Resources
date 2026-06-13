public class Main {
    public static void main(String[] args) {
        GeneralSupport generalSupport = new GeneralSupport();
        BillingSupport billingSupport = new BillingSupport();
        TechnicalSupport technicalSupport = new TechnicalSupport();
        DeliverySupport deliverySupport = new DeliverySupport();


        // Setting up the chain: general -> billing -> technical -> delivery
        generalSupport.setNextHandler(billingSupport);
        billingSupport.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(deliverySupport);

        // Testing the chain of responsibility with different request types
        generalSupport.handleRequest("refund");
        generalSupport.handleRequest("delivery");
        generalSupport.handleRequest("unknown");
    }
}
