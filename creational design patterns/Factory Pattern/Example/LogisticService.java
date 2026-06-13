public class LogisticService {
    // here we are using the factory method to create the logistic object based on the mode of transportation
    // this way we can easily add new modes of transportation without changing the code in the LogisticService class
    // LogisticService class is the client that uses the factory method to create the logistic object and call the send method
    // LogisticService class is decoupled from the concrete implementations of the logistic objects, it only depends on the Logistics interface
    // this is the main advantage of using the factory method pattern, it allows us to create objects without exposing the creation logic to the client and refer to the newly created object using a common interface
    public void send(String mode) {
        Logistics logistic = LogisticFactory.createLogistics(mode);
        logistic.send();
    }
}
