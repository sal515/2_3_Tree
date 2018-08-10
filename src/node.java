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


    public node create2NodeLeaf(int key1, node parent) {
        node newNode = new t23_2Node_Leaf();
        newNode.setKey1(key1);
        newNode.setParent(parent);
        return newNode;
    }


    public node create2NodeInternal(int key1, node parent,
                                    node left, node right) {
        node newNode = new t23_2Node_Internal();
        newNode.setKey1(key1);
        newNode.setLeftChild(left);
        newNode.setRightChild(right);
        newNode.setParent(parent);
        return newNode;
    }


    public node create3NodeLeaf(int key1, int key2, node parent) {
        node newNode = new t23_3Node_Leaf();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setParent(parent);
        return newNode;
    }

    public node create3NodeInternal(int key1, int key2, node parent,
                                    node left, node middle, node right) {
        node newNode = new t23_3Node_Internal();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setLeftChild(left);
        newNode.setRightChild(right);
        newNode.setMiddleChild(middle);
        newNode.setParent(parent);
        return newNode;
    }


    public node create4NodeInternal(int key1, int key2, int key3, node parent,
                                    node left, node middle, node right, node fourthTemp) {
        node newNode = new t23_temp4NodeInternal();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setKey3(key3);
        newNode.setLeftChild(left);
        newNode.setRightChild(right);
        newNode.setMiddleChild(middle);
        newNode.setFourthChildTemp(fourthTemp);
        newNode.setParent(parent);
        return newNode;
    }

    public node create4NodeLeaf(int key1, int key2, int key3, node parent) {
        node newNode = new t23_temp4NodeLeaf();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setKey3(key3);
        newNode.setParent(parent);
        return newNode;
    }


    // making 2 node root from null
    public node build_2NodeRootLeaf(int key) {
        node newNode = create2NodeLeaf(key, null);
        return newNode;
    }

    // making 3 node root from 2 node root
    public node build_3NodeRootLeaf(int key, int insertKeyPos, node twoNodeRoot) {
        // if insert key position is 0 , new key goes on left
        node newNode = null;
        if (insertKeyPos == 0) {
            newNode = create3NodeLeaf(key, twoNodeRoot.getKey1(), twoNodeRoot.getParent());
        }
        // if insert key position is other than 0, new key goes on the right
        else newNode = create3NodeLeaf(twoNodeRoot.getKey1(), key, twoNodeRoot.getParent());
        return newNode;
    }


    // splitting 3 node root to 3x new 2 node
    public node[] split_3nodeRootLeaf(int key, int insertKeyPos, node threeNodeRoot) {
        // What the positions mean int the return array
        int parentPos = 0;
        int leftChildPos = 1;
        int rightChildPos = 2;

        node newNodes[] = new node[3];
        // if insert key position is 0 , new key is left child
        if (insertKeyPos == 0) {
            newNodes[parentPos] = create2NodeLeaf(threeNodeRoot.getKey1(), null);
            newNodes[leftChildPos] = create2NodeLeaf(key, newNodes[0]);
            newNodes[rightChildPos] = create2NodeLeaf(threeNodeRoot.getKey2(), newNodes[0]);
        }
        // if insert key position is 1 , new key is middle child
        else if (insertKeyPos == 1) {
            newNodes[parentPos] = create2NodeLeaf(key, null);
            newNodes[leftChildPos] = create2NodeLeaf(threeNodeRoot.getKey1(), newNodes[0]);
            newNodes[rightChildPos] = create2NodeLeaf(threeNodeRoot.getKey2(), newNodes[0]);
        }
        // if insert key position is 2 or o.w. , new key is right child
        else {
            newNodes[parentPos] = create2NodeLeaf(threeNodeRoot.getKey2(), null);
            newNodes[leftChildPos] = create2NodeLeaf(threeNodeRoot.getKey1(), newNodes[0]);
            newNodes[rightChildPos] = create2NodeLeaf(key, newNodes[0]);
        }
        return newNodes;
    }


    // ====================== overridden  functions  ===================================


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
