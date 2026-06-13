import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel {
    private List<Subscriber> subscriberList;
    private String name;
    private String title;

    YoutubeChannel(String name) {
        subscriberList = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for(Subscriber subscriber : subscriberList) {
            subscriber.update(title);
        }
    }

    @Override
    public void uploadVideo(String title) {
        this.title = title;
        notifySubscriber();
    }
}
