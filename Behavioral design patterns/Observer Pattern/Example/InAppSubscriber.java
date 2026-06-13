public class InAppSubscriber implements Subscriber {
    private String userName;
    InAppSubscriber(String email) {
        this.userName = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("inapp Notification sent to " + userName + ": New video uploaded - " + videoTitle);
    }
}
