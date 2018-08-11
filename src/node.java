public abstract class node {

    // ====================== Member variables ===================================

    private node parent;

    // ====================== Member variables ===================================

    node() {
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

    public node getFourthChildTemp() {
        return null;
    }

    public void setFourthChildTemp(node fourthChildTemp) {
    }

    public int getKey3() {
        return -99;
    }

    public void setKey3(int key3) {
    }

    // ====================== undefined overridden  functions  ===================================

    // ====================== abstract member functions ===================================

    abstract boolean isLeaf();

    // ====================== abstract member functions ===================================

    // ======================  member functions ===================================

    public boolean isRoot(node nodeObj) {
        return nodeObj.getParent() == null;
    }


    static node initializeNode(node outNode, node parent, node rightChild, node leftChild,
                               node middleChild, int key1, int key2) {

        // available options:
        // ------------------
        // 1. 3nodeInternal
        // 2. 3nodeLeaf
        // 3. 2nodeInternal
        // 4. 2nodeLeaf

//        outNode instanceof t23_2Node_Internal
//        outNode instanceof t23_2Node_Leaf
//        outNode instanceof t23_3Node_Internal
//        outNode instanceof t23_3Node_Leaf

        if (outNode instanceof t23_3Node_Internal) {
            // 3-node internal
            outNode.setParent(parent);
            outNode.setLeftChild(leftChild);
            outNode.setRightChild(rightChild);
            outNode.setMiddleChild(middleChild);
            outNode.setKey1(key1);
            outNode.setKey2(key2);
            return outNode;
        } else if (outNode instanceof t23_3Node_Leaf) {
            // 3-node leaf
            outNode.setParent(parent);
            outNode.setKey1(key1);
            outNode.setKey2(key2);
            return outNode;
        } else if (outNode instanceof t23_2Node_Internal) {
            // 2-node internal
            outNode.setParent(parent);
            outNode.setLeftChild(leftChild);
            outNode.setRightChild(rightChild);
            outNode.setKey1(key1);
            return outNode;
        } else {
            // 2-node leaf
            outNode.setParent(parent);
            outNode.setKey1(key1);
            return outNode;
        }


//        if (is3node() && !isLeaf()) {
//            // 3-node internal
//            outNode.setParent(parent);
//            outNode.setLeftChild(leftChild);
//            outNode.setRightChild(rightChild);
//            outNode.setMiddleChild(middleChild);
//            outNode.setKey1(key1);
//            outNode.setKey2(key2);
//            return outNode;
//        } else if (is3node() && isLeaf()) {
//            // 3-node leaf
//            outNode.setParent(parent);
//            outNode.setKey1(key1);
//            outNode.setKey2(key2);
//            return outNode;
//        } else if (!is3node() && !isLeaf()) {
//            // 2-node internal
//            outNode.setParent(parent);
//            outNode.setLeftChild(leftChild);
//            outNode.setRightChild(rightChild);
//            outNode.setKey1(key1);
//            return outNode;
//        } else {
//            // 2-node leaf
//            outNode.setParent(parent);
//            outNode.setKey1(key1);
//            return outNode;
//        }


//        switch (nodeType) {
//            case "3nodeInternal":
//                // 3-node internal
//                outNode.setParent(parent);
//                outNode.setLeftChild(leftChild);
//                outNode.setRightChild(rightChild);
//                outNode.setMiddleChild(middleChild);
//                outNode.setKey1(key1);
//                outNode.setKey2(key2);
//                break;
//            case "3nodeLeaf":
//                // 3-node leaf
//                outNode.setParent(parent);
//                outNode.setKey1(key1);
//                outNode.setKey2(key2);
//                break;
//            case "2nodeInternal":
//                // 2-node internal
//                outNode.setParent(parent);
//                outNode.setLeftChild(leftChild);
//                outNode.setRightChild(rightChild);
//                outNode.setKey1(key1);
//                break;
//            case "2nodeLeaf":
//                // 2-node leaf
//                outNode.setParent(parent);
//                outNode.setKey1(key1);
//                break;
//            default:
//                return null;
//        }
//        return outNode;

    }


    // ======================  member functions ===================================


    // ====================== getters and setters ===================================


    public node getParent() {
        return parent;
    }

    public void setParent(node parent) {
        this.parent = parent;
    }

    // ====================== getters and setters  ===================================

}
