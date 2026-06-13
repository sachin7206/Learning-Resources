import java.util.ArrayList;
import java.util.List;

public class YouTubePlayList implements Playlist {
    List<Video> videos;
    PlayListIterator playListIterator;
    YouTubePlayList() {
        videos = new ArrayList<>();
    }
    @Override
    public void addVideo(Video video) {
        videos.add(video);
    }

    @Override
    public PlayListIterator createIterator() {
        playListIterator = new YouTubePlayListIterator(videos);
        return playListIterator;
    }
}
