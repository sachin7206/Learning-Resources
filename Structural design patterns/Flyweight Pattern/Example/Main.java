class Main {
    public static void main(String args[]) {
        Forest forest = new Forest();

        // Planting 1 million trees
        for(int i = 0; i < 1000000; i++) {
            forest.plantTree(i, i, "Oak", "Green", "Rough");
        }

        forest.draw();

        System.out.println("Planted 1 million trees.");
    }
}