public class DigitalProduct implements Item {
    String name;
    int downloadSizeInMB;

    public DigitalProduct(String name, int downloadSizeInMB) {
        this.name = name;
        this.downloadSizeInMB = downloadSizeInMB;
    }

    @Override
    public void accept(ItemVisitor itemVisitor) {
        itemVisitor.visit(this);
    }
}
