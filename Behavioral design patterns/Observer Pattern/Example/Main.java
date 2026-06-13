public class Main {
    public static void main(String[] args) {
        Channel sachinFitnessChannel = new YoutubeChannel("Sachin fitness Channel");
        sachinFitnessChannel.addSubscriber(new EmailSubscriber("user1@gmail.com"));
        sachinFitnessChannel.addSubscriber(new EmailSubscriber("user2@gmail.com"));
        sachinFitnessChannel.addSubscriber(new InAppSubscriber("user3"));

        sachinFitnessChannel.uploadVideo("chest press exercise");
    }
}
