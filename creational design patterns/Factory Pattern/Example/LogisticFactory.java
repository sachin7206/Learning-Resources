public class LogisticFactory {
    public static Logistics createLogistics(String type) {
        if (type.equalsIgnoreCase("road")) {
            return new RoadLogistic();
        } else if (type.equalsIgnoreCase("train")) {
            return new TrainLogistics();
        } else {
            throw new IllegalArgumentException("Unknown logistics type: " + type);
        }
    }
}
