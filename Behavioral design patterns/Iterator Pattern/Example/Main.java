class Main {
    public static void main(String args[]) {
        Playlist youTubePlayList = new YouTubePlayList();
        youTubePlayList.addVideo(new Video("video1"));
        youTubePlayList.addVideo(new Video("video2"));

        PlayListIterator youTubePlayListIterator = youTubePlayList.createIterator();
        while (youTubePlayListIterator.hasNext()) {
            System.out.println(youTubePlayListIterator.next().getTitle());
        }
    }
}