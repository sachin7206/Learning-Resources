abstract class Player {
    protected VideoQuality quality;

    public Player(VideoQuality quality) {
        this.quality = quality;
    }

    public abstract void play(String title);
}