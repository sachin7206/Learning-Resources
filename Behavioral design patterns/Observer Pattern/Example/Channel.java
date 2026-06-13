public interface Channel {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber();
    void uploadVideo(String title);
}
