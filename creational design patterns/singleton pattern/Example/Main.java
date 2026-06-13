public class Main {
    public static void main(String[] args) {
        JudgeAnalytics analytics1 = JudgeAnalytics.getInstance();
        JudgeAnalytics analytics2 = JudgeAnalytics.getInstance();

        // Check if both instances are the same
        if (analytics1 == analytics2) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Instances are different. Singleton pattern is not working.");
        }
    }
}