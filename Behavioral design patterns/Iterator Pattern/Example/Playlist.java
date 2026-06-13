public interface Playlist {
    void addVideo(Video video);
    PlayListIterator createIterator();
}
