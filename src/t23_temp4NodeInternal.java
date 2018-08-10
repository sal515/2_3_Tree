public class t23_temp4NodeInternal extends threeNodeInternal {

    // int nodeIndex
    // int key1
    // int key2
    // int key3
    // node leftChild
    // node rightChild
    // node MiddleChild
    // node fourthChild
    // node parent

    node fourthChildTemp;
    int key3;

    @Override
    boolean isLeaf() {
        return false;
    }

    @Override
    public node getFourthChildTemp() {
        return fourthChildTemp;
    }

    @Override
    public void setFourthChildTemp(node fourthChildTemp) {
        this.fourthChildTemp = fourthChildTemp;
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
