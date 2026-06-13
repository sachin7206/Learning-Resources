public class Main {
    public static void main(String[] args) {
        NotificationSender emailSender = new EmailNotification();
        emailSender.send("john@example.com", "Welcome to bisht fitness");

        System.out.println(" ");

        NotificationSender smsSender = new SMSNotification();
        smsSender.send("378129381923", "Your OTP is 4567.");
    }
}
