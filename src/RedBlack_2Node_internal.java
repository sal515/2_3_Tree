public class RedBlack_2Node_internal extends twoNodeInternal  {
    boolean color;  // true - if red
    boolean isRed() {
        return this.getColor();
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    boolean isLeaf() {
        return false;
    }
}
