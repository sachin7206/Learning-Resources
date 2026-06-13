import java.util.List;

public class YouTubePlayListIterator implements PlayListIterator {
    private final List<Video> videos;
    private int position = 0;
    private final int size;
    YouTubePlayListIterator(List<Video> videos) {
        size = videos.size();
        this.videos = videos;
    }

    @Override
    public boolean hasNext() {
        if (position >= size) return false;
        return true;
    }

    @Override
    public Video next() {
        if(hasNext()) {
            return videos.get(position++);
        }
        return null;
    }
}
