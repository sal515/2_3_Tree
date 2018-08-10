abstract class threeNodeInternal extends node {
    // ====================== Member variables ===================================

    //    int[] key = new int[2];
    private int key1 = 0;
    private int key2 = 0;
    private node rightChild = null;
    private node middleChild = null;
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
    public int getKey2() {
        return key2;
    }

    @Override
    public void setKey2(int key2) {
        this.key2 = key2;
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
    public node getMiddleChild() {
        return middleChild;
    }

    @Override
    public void setMiddleChild(node middleChild) {
        this.middleChild = middleChild;
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
