public abstract class node implements Cloneable {

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

    public node nodeCopy(node in) {
        node out = null;
        if (in instanceof t23_2Node_Leaf) {
            out = new t23_3Node_Leaf();
            out.setKey1(in.getKey1());
            out.setParent(in.getParent());
            out.setChildPos(in.getChildPos());
        }
        if (in instanceof t23_2Node_Internal) {
            out = new t23_2Node_Internal();
            out.setKey1(in.getKey1());
            out.setParent(in.getParent());
            out.setChildPos(in.getChildPos());
            out.setLeftChild(in.getLeftChild());
            out.setRightChild(in.getRightChild());
        }
        if (in instanceof t23_3Node_Leaf) {
            out = new t23_3Node_Leaf();
            out.setKey1(in.getKey1());
            out.setKey2(in.getKey2());
            out.setParent(in.getParent());
            out.setChildPos(in.getChildPos());
        }
        if (in instanceof t23_3Node_Internal) {
            out = new t23_3Node_Internal();
            out.setKey1(in.getKey1());
            out.setKey2(in.getKey2());
            out.setParent(in.getParent());
            out.setChildPos(in.getChildPos());
            out.setLeftChild(in.getLeftChild());
            out.setMiddleChild(in.getMiddleChild());
            out.setRightChild(in.getRightChild());

        }
        return out;
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
