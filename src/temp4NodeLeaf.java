public class temp4NodeLeaf extends threeNodeLeaf {

    int key3;

    @Override
    boolean isLeaf() {
        return false;
    }

    @Override
    public int getKey3() {
        return key3;
    }

    @Override
    public void setKey3(int key3) {
        this.key3 = key3;
    }
}
