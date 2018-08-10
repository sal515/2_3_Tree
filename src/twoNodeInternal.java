abstract class twoNodeInternal extends node{
    // ====================== Member variables ===================================

    // int nodeIndex
    // int key1
    // node leftChild
    // node rightChild
    // node parent

    private int key1 = 0;
    private node rightChild = null;
    private node leftChild = null;

    // ====================== Member variables ===================================

    // ====================== getters and setters ===================================
    @Override
    public int getKey1() {
        return key1;
    }

    @Override
    public void setKey1(int key1) {
        this.key1 = key1;
    }

    @Override
    public node getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public node getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(node leftChild) {
        this.leftChild = leftChild;
    }

    // ====================== getters and setters ===================================

}
