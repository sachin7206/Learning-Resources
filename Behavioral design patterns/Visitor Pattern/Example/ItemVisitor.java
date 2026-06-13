// ======== Visitor Interface ============
public interface ItemVisitor {
    void visit(PhysicalProduct physicalProduct);
    void visit(DigitalProduct digitalProduct);
    void visit(GiftCard giftCard);
}
