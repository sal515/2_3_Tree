public abstract class node {

    // ====================== Member variables ===================================

    private node parent;

    // childPos = -1 - not a child
    // childPos = 0 - left child
    // childPos = 1 - middle child
    // childPos = 2 - right child
    private int childPos;

    // ====================== Member variables ===================================

    node() {
        childPos = -1;
        setParent(null);
    }

    // ====================== Undefined overridden  functions ===================================
    // ====================== Downcasting checks are done maually ===================================

    boolean is3node() {
        return false;
    }

    int getKey1() {
        return -99;
    }

    public void setKey1(int key1) {
    }

    public int getKey2() {
        return -99;
    }

    public void setKey2(int key2) {
    }

    public node getRightChild() {
        return null;
    }

    public void setRightChild(node rightChild) {
    }

    public node getLeftChild() {
        return null;
    }

    public void setLeftChild(node leftChild) {
    }

    public node getMiddleChild() {
        return null;
    }

    public void setMiddleChild(node middleChild) {
    }

    // ====================== undefined overridden  functions  ===================================

    // ====================== abstract member functions ===================================

    abstract boolean isLeaf();

    // ====================== abstract member functions ===================================

    // ======================  member functions ===================================

    public boolean isRoot(node nodeObj) {
        return nodeObj.getParent() == null;
    }

    // ======================  member functions ===================================

    // ====================== getters and setters ===================================


    public int getChildPos() {
        return childPos;
    }

    public void setChildPos(int childPos) {
        this.childPos = childPos;
    }

    public node getParent() {
        return parent;
    }

    public void setParent(node parent) {
        this.parent = parent;
    }

    // ====================== getters and setters  ===================================

}
