class HdQuality implements VideoQuality {
    @Override
    public void load(String title) {
        System.out.println("Streaming " + title + " in HD Quality");
    }
}