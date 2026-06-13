class Main {
    public static void main(String[] args) {
        Player player1 = new MobilePlayer(new HdQuality());
        player1.play("HdQuality");
        Player player2 = new WebPlayer(new SDQuality());
        player2.play("SdQuality");
    }
}