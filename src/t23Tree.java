public class t23Tree extends tree {

    // ====================== Member variables ===================================

    // node root
    // int size
    // stack stackObj

    // ====================== Member variables ===================================


    // ====================== Member functions ===================================


    // ====================== node creating function ===================================

    public node create2NodeLeaf(int key1, node parent, int childPos) {
        node newNode = new t23_2Node_Leaf();
        newNode.setKey1(key1);
        newNode.setParent(parent);
        newNode.setChildPos(childPos);
        return newNode;
    }

    public node create2NodeInternal(int key1, node parent,
                                    node left, node right, int childPos) {
        node newNode = new t23_2Node_Internal();
        newNode.setKey1(key1);
        newNode.setLeftChild(left);
        newNode.setRightChild(right);
        newNode.setParent(parent);
        newNode.setChildPos(childPos);
        return newNode;
    }

    public node create3NodeLeaf(int key1, int key2, node parent, int childPos) {
        node newNode = new t23_3Node_Leaf();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setParent(parent);
        newNode.setChildPos(childPos);
        return newNode;
    }

    public node create3NodeInternal(int key1, int key2, node parent,
                                    node left, node middle, node right, int childPos) {
        node newNode = new t23_3Node_Internal();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setLeftChild(left);
        newNode.setRightChild(right);
        newNode.setMiddleChild(middle);
        newNode.setParent(parent);
        newNode.setChildPos(childPos);
        return newNode;
    }

//    public node create4NodeInternal(int key1, int key2, int key3, node parent,
//                                    node left, node middle, node right, node fourthTemp) {
//        node newNode = new t23_temp4NodeInternal();
//        newNode.setKey1(key1);
//        newNode.setKey2(key2);
//        newNode.setKey3(key3);
//        newNode.setLeftChild(left);
//        newNode.setRightChild(right);
//        newNode.setMiddleChild(middle);
//        newNode.setFourthChildTemp(fourthTemp);
//        newNode.setParent(parent);
//        return newNode;
//    }
//
//    public node create4NodeLeaf(int key1, int key2, int key3, node parent) {
//        node newNode = new t23_temp4NodeLeaf();
//        newNode.setKey1(key1);
//        newNode.setKey2(key2);
//        newNode.setKey3(key3);
//        newNode.setParent(parent);
//        return newNode;
//    }

    // ====================== node creating function ===================================


    // ====================== node convert and build functions ===================================

//    // making 2 node root from null
//    public node build_2Node_RootLeaf(int key) {
//        node newNode = create2NodeLeaf(key, null);
//        return newNode;
//    }

//    // converting to a 3 node leaf from 2 node leaf
//    public node convert_3NodeL_from_2NodeL(int key, int insertKeyPos, node twoNode) {
//        // if insert key position is 0 , new key goes on left
//        node threeNode = null;
//        if (insertKeyPos == 0) {
//            threeNode = create3NodeLeaf(key, twoNode.getKey1(), twoNode.getParent());
//        }
//        // if insert key position is other than 0, new key goes on the right
//        else threeNode = create3NodeLeaf(twoNode.getKey1(), key, twoNode.getParent());
//        twoNode = null;
//        return threeNode;
//    }
//
//    // converting to a 3 node internal from 2 node internal
//    public node convert_3NodeI_from_2NodeI(int key, int insertKeyPos, node twoNode) {
//        // if insert key position is 0 , new key goes on left
//        node threeNode = null;
//        if (insertKeyPos == 0) {
//            threeNode = create3NodeInternal(key, twoNode.getKey1(), twoNode.getParent(), twoNode.getLeftChild(),
//                    twoNode.getMiddleChild(), twoNode.getRightChild());
//        } else if (insertKeyPos == 1) {
//
//        }
//        // if insert key position is other than 0, new key goes on the right
//        else {
//            threeNode = create3NodeLeaf(twoNode.getKey1(), key, twoNode.getParent());
//        }
//        twoNode = null;
//        return threeNode;
//    }

    // ====================== node building functions ===================================

    // ====================== split and promote functions ===================================


    // splitting 3 node root to 3x new 2 node : returns parent (2N) , left and right children (2N)
    public node split_3NodeLeaf(int key, int insertKeyPos, node threeNode) {

        node retNode = null;

        // insert key is smalller than key1
        if (insertKeyPos == 0) {
            retNode = create2NodeInternal(threeNode.getKey1(), threeNode.getParent(),
                    null, null, -1);
            retNode.setLeftChild(create2NodeLeaf(key, retNode, 0));
            retNode.setRightChild(create2NodeLeaf(threeNode.getKey2(), retNode, 2));
        }
        // insert key is larger than key1 and smaller than key2
        else if (insertKeyPos == 1) {
            retNode = create2NodeInternal(
                    key, threeNode.getParent(),
                    null, null, -1);

            retNode.setLeftChild(create2NodeLeaf(threeNode.getKey1(), retNode, 0));
            retNode.setRightChild(create2NodeLeaf(threeNode.getKey2(), retNode, 2));

        }
        // insert key is larger than key2
        else if (insertKeyPos == 2) {
            retNode = create2NodeInternal(
                    threeNode.getKey2(), threeNode.getParent(),
                    null, null, -1);
            retNode.setLeftChild(create2NodeLeaf(threeNode.getKey1(), retNode, 0));
            retNode.setRightChild(create2NodeLeaf(key, retNode, 2));
        }

        return retNode;

        // What the positions mean int the return array
//        int parentPos = 0;
//        int leftChildPos = 1;
//        int rightChildPos = 2;
//
//        node newNodes = new t23_2Node_Leaf();

//        // if insert key position is 0 , new key is left child
//        if (insertKeyPos == 0) {
//            newNodes[parentPos] = create2NodeLeaf(threeNode.getKey1(), null);
//            newNodes[leftChildPos] = create2NodeLeaf(key, newNodes[parentPos]);
//            newNodes[rightChildPos] = create2NodeLeaf(threeNode.getKey2(), newNodes[parentPos]);
//        }
//        // if insert key position is 1 , new key is middle child
//        else if (insertKeyPos == 1) {
//            newNodes[parentPos] = create2NodeLeaf(key, null);
//            newNodes[leftChildPos] = create2NodeLeaf(threeNode.getKey1(), newNodes[parentPos]);
//            newNodes[rightChildPos] = create2NodeLeaf(threeNode.getKey2(), newNodes[parentPos]);
//        }
//        // if insert key position is 2 or o.w. , new key is right child
//        else {
//            newNodes[parentPos] = create2NodeLeaf(threeNode.getKey2(), null);
//            newNodes[leftChildPos] = create2NodeLeaf(threeNode.getKey1(), newNodes[parentPos]);
//            newNodes[rightChildPos] = create2NodeLeaf(key, newNodes[parentPos]);
//        }
//        threeNode = null;
//        return newNodes;
    }

    // ====================== split and promote functions ===================================

    @Override
    boolean addHelp(int val, node rt, tree treeObj) {
        node targetNode = treeObj.addFindHelp(val, rt, treeObj);
        // ------------------------------------------------------
        // testing function
        TwoThree.checkAddFindHelper(treeObj, targetNode);
        System.out.println();
        // ------------------------------------------------------

        int firstPosition = treeObj.getTargetLocation3Node();

        // Either the root is empty or the value already exists
        // - not added - but the comparisons are counted
        if (targetNode == null) {
            return false;
        }
        // if the target node is a leaf
        if (targetNode.isLeaf()) {
            // the target node is a 2-node
            if (!targetNode.is3node()) {
                // if the target node is the ROOT NODE
                if (treeObj.getRoot().isRoot(targetNode)) {
                    node temp = null;
                    // if the position is 0 , that means the insert key is smaller then 2-node key
                    if (firstPosition == 0) {
                        temp = create3NodeLeaf(val, targetNode.getKey1(), null,
                                targetNode.getChildPos());
                    } else {
                        temp = create3NodeLeaf(targetNode.getKey1(), val, null,
                                targetNode.getChildPos());
                    }
                    treeObj.setRoot(temp);
                }
                // the target node is not a root node but it is a regular leaf
                else {
                    node temp = null;
                    // if the position is 0 , that means the insert key is smaller then 2-node key
                    if (firstPosition == 0) {
                        temp = create3NodeLeaf(val, targetNode.getKey1(), targetNode.getParent(),
                                targetNode.getChildPos());
                    } else {
                        temp = create3NodeLeaf(targetNode.getKey1(), val, targetNode.getParent(),
                                targetNode.getChildPos());
                    }
                    // setting the left child
                    if (targetNode.getChildPos() == 0) {
                        targetNode.getParent().setLeftChild(temp);
                    }
                    // setting the right child
                    else if (targetNode.getChildPos() == 2) {
                        targetNode.getParent().setRightChild(temp);
                    }
                    // setting the middle child
                    else {
                        targetNode.getParent().setMiddleChild(temp);
                    }
                }

            }
            // the target node is a 3-node
            else {
                // splits the 3-node keys into 2x 2-nodes that points to the 3-node as the parent
                // the 3-node leaf is Root
                if (treeObj.getRoot().isRoot(targetNode)) {
                    treeObj.setRoot(split_3NodeLeaf(val, firstPosition, targetNode));
                }
                // the 3-node leaf is not a root
                else {
                    targetNode = split_3NodeLeaf(val, firstPosition, targetNode);
                }


            }
        }


        return false;


        /*
        node targetNode = addFindHelp(val, rt);
        if (targetNode != null) {
            if (targetNode.is3node()) {
                System.out.println(targetNode.getKey1() + " " + targetNode.getKey2());
                System.out.println(getTargetLocation3Node());
            } else {
                System.out.println(targetNode.getKey1());
            }
        }

        // root == null
        // 1. make a new 2-node
        // 2. insert into the 2-node - single key
        if (treeObj.isEmpty(treeObj.getRoot())) {
            treeObj.setRoot(node.initializeNode(new t23_2Node_Leaf(), null,
                    null, null, null, val, -1));
        }
       */

        // insert into a 2-node -> root (no parent)
        // -> !is3node && isRoot
        // 1. replace the 2-node with a new 3-node
        // 2. insert into the 3-node - both keys


        // insert into a 3-node -> root (no parent)
        // -> is3node && isRoot
        // 1. (split) replace the 3-node with 3 new 2-nodes
        // 2. (promote) insert into the 1 2-node - the middle key (new root)
        // 3. insert into the 2 2-nodes - left and right keys (2 children)

        // insert into a 3-node with 2-node parent
        // -> is3node && !isRoot && !getParent.is3node
        // 1. (split)replace the 3-node with 2 2-nodes
        // 2. (promote) insert into the parent 2-node - the middle key
        // 3. insert into the new 2 2-nodes - left and right keys of the original 3-node


        // insert into a 3-node with 3-node parent
        // -> is3node && !isRoot && getParent.is3node && !getParent.isRoot
        // 1. (split) replace the target 3-node with 2 2-nodes
        // 3. (promote) the middle value of the target 3-node to the parent 3-node
        // 2. (split) replace the parent 3-node with 3 2-nodes
        // 4. (promote) the middle value of the parent 3-node to parent 2-node
        // 5. repeat above steps if root is imvolved

        // Split the root
        // --> is3node && !isRoot && getParent.is3node && getParent.isRoot
        //

    }

    // returns null if insert value is found, else returns the target node

    @Override
    node addFindHelp(int val, node rt, tree treeObj) {

        if (isEmpty(rt)) {
            treeObj.setRoot(new t23_2Node_Leaf());
            treeObj.getRoot().setKey1(val);
            treeObj.getRoot().setParent(null);
            return null;
        }

        int checkKey1 = rt.getKey1();
        int checkKey2 = -1;
        if (rt.is3node()) checkKey2 = rt.getKey2();

        // if node is null - create a new root and return null

        // if 3-node - do following:
        if (rt.is3node()) {
            // going Left of key1 - if insertKey less then key1
            if (val < checkKey1) {
                comparisonsIncrement(1);
                if (rt.isLeaf()) {
                    setTargetLocation3Node(0);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getLeftChild(), treeObj);
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                // going left of key2 - if insertKey less then key2
                if (val < checkKey2) {
                    comparisonsIncrement(1);
                    if (rt.isLeaf()) {
                        setTargetLocation3Node(1);
                        return rt;
                    } else {
                        return addFindHelp(val, rt.getMiddleChild(), treeObj);
                    }
                }
                // going right of key2 - if insertKey greater then key2
                else if (val > checkKey2) {
                    comparisonsIncrement(2);
                    if (rt.isLeaf()) {
                        setTargetLocation3Node(2);
                        return rt;
                    } else {
                        return addFindHelp(val, rt.getRightChild(), treeObj);
                    }
                }
                // key is the key2 of 3 node
                else {
                    comparisonsIncrement(2);
                    setisKey2Find(true);
                    return null;
                }
            }
            // key is the key1 of 3 node
            else {
                comparisonsIncrement(2);
                setisKey2Find(false);
                return null;
            }
        }
        // if 2-node - do following:
        else {
            // going Left of key1 - if insertKey less then key1
            if (val < checkKey1) {
                comparisonsIncrement(1);
                if (rt.isLeaf()) {
                    setTargetLocation3Node(0);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getLeftChild(), treeObj);
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) {
                    setTargetLocation3Node(1);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getRightChild(), treeObj);
                }
            }
            // key is the key1 of 2-node
            else {
                comparisonsIncrement(2);
                setisKey2Find(false);
                return null;
            }
        }
    }


    @Override
    boolean add(int val, node rt) {
        return false;
    }

    @Override
    void traverse(node rt) {

    }

    @Override
    node remove(int val) {
        return null;
    }

    @Override
    boolean isEmpty(node rt) {
        return rt == null;
    }

    @Override
    node find(int val, node rt) {
        // in general - checkKey1 < checkKey2

        // storing the temp variables
        int checkKey1 = rt.getKey1();
        int checkKey2 = -1;
        if (rt.is3node()) checkKey2 = rt.getKey2();

        // if node is null - returns null obj
        if (isEmpty(rt)) return null;
        // if 3-node - do following:
        if (rt.is3node()) {
            // going Left of key1 - if insertKey less then key1
            if (val < checkKey1) {
                comparisonsIncrement(1);
                if (rt.isLeaf()) return null;
                else return find(val, rt.getLeftChild());
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                // going left of key2 - if insertKey less then key2
                if (val < checkKey2) {
                    comparisonsIncrement(1);
                    if (rt.isLeaf()) return null;
                    else return find(val, rt.getMiddleChild());
                }
                // going right of key2 - if insertKey greater then key2
                else if (val > checkKey2) {
                    comparisonsIncrement(2);
                    if (rt.isLeaf()) return null;
                    else return find(val, rt.getRightChild());
                }
                // key is the key2 of 3 node
                else {
                    comparisonsIncrement(2);
                    setisKey2Find(true);
                    return rt;
                }
            }
            // key is the key1 of 3 node
            else {
                comparisonsIncrement(2);
                setisKey2Find(false);
                return rt;
            }
        }
        // if 2-node - do following:
        else {
            // going Left of key1 - if insertKey less then key1
            if (val < checkKey1) {
                comparisonsIncrement(1);
                if (rt.isLeaf()) return null;
                else return find(val, rt.getLeftChild());
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) return null;
                else return find(val, rt.getRightChild());
            }
            // key is the key1 of 2-node
            else {
                comparisonsIncrement(2);
                setisKey2Find(false);
                return rt;
            }
        }
    }


    // ====================== Member functions ===================================
}
