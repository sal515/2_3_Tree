public class t23Tree extends tree {

    @Override
    boolean add(int val, node rt, tree treeObj) {
        addInstructionCounterIncrement();
        node targetNode = treeObj.addFindHelp(val, rt, treeObj);
        // ------------------------------------------------------
        // testing function
//        TwoThree.checkAddFindHelper(treeObj, targetNode);
//        System.out.println();
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
                    targetNode = setTargetNodePtr(targetNode, temp);
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
                    targetNode = setTargetNodePtr(targetNode,
                            split_3NodeLeaf(val, firstPosition, targetNode));

                    promote(targetNode, treeObj);
                }
            }
        }
        return false;
    }


    // ====================== Member functions ===================================


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
    }

    void promote(node targetNode, tree treeObj) {
        // setting the children of the new 3-node parent

        if (targetNode.getParent() != null) {
            // the parent of the 3-node that was split is a 2-node
            if (!targetNode.getParent().is3node()) {
                node temp = null;
                if (targetNode.getParent().getKey1() > targetNode.getKey1()) {
                    temp = create3NodeInternal(targetNode.getKey1(),
                            targetNode.getParent().getKey1(),
                            targetNode.getParent().getParent(),
                            targetNode.getLeftChild(),
                            targetNode.getRightChild(),
                            targetNode.getParent().getRightChild(),
                            targetNode.getParent().getChildPos());
                } else {
                    temp = create3NodeInternal(targetNode.getParent().getKey1(),
                            targetNode.getKey1(),
                            targetNode.getParent().getParent(),
                            targetNode.getParent().getLeftChild(),
                            targetNode.getLeftChild(),
                            targetNode.getRightChild(),
                            targetNode.getParent().getChildPos());
                }
                // setting the parent of the children to the new 3-node
                temp.getLeftChild().setParent(temp);
                temp.getRightChild().setParent(temp);
                temp.getMiddleChild().setParent(temp);
                // setting the position of the children in respect to the new parent
                temp.getLeftChild().setChildPos(0);
                temp.getMiddleChild().setChildPos(1);
                temp.getRightChild().setChildPos(2);

                // parent of the target is a ROOT
                if (targetNode.getParent().isRoot(targetNode.getParent())) {
                    treeObj.setRoot(temp);
                    targetNode = treeObj.getRoot();
                }
                // parent of the target is not a root
                else {
                    targetNode = setTargetNodePtr(targetNode.getParent(), temp);
                }
            }
            // the parent of the 3-node that was split is a 3-node
            // here the temporary 2-node head is to be merged with the internal 3-node after
            // it splits

            else {
                split_3NodeInternal(targetNode, treeObj);

                if (targetNode.getParent() != null) {
                    promote(targetNode.getParent(), treeObj);
                }
            }
        }
    }


    //  splitting 3 node internal root to be able to
    // obsorb the 3-node leaf that was already split
    node split_3NodeInternal(node targetNode, tree treeObj) {
        node preserveTargetNodeParent = targetNode.getParent();
//        node preserveTargetNodeGrandParent = targetNode.getParent().getParent();
        int preservePosition = targetNode.getParent().getChildPos();
        node tempNode1 = null; // PK1
        node tempNode2 = null; // PK2
        // insertkey < parentKey1
        // the insert key is on the left of 3-node parent key1
        if (targetNode.getParent().getKey1() > targetNode.getKey1()) {
            // creating 2x 2-nodes and setting their children
            tempNode1 = create2NodeInternal(
                    targetNode.getParent().getKey1(),
                    targetNode.getParent().getParent(),
                    targetNode,
                    tempNode2,
                    targetNode.getParent().getChildPos());
            tempNode2 = create2NodeInternal(
                    targetNode.getParent().getKey2(),
                    tempNode1,
                    targetNode.getParent().getMiddleChild(),
                    targetNode.getParent().getRightChild(),
                    2);
            // pointing the children towards their respective parent after rearrangement
            tempNode1.setRightChild(tempNode2);
            tempNode2.setParent(tempNode1);
            targetNode.setParent(tempNode1);
            tempNode2.getLeftChild().setParent(tempNode2);
            tempNode2.getRightChild().setParent(tempNode2);
            // setting the childPos for all the rearranged nodes
            targetNode.setChildPos(0);
            tempNode2.getLeftChild().setChildPos(0);
            tempNode2.getRightChild().setChildPos(2);

            if (treeObj.getRoot().isRoot(preserveTargetNodeParent)) {
                treeObj.setRoot(tempNode1);
            } else {
                setTargetNodePtr(preserveTargetNodeParent, tempNode1, preservePosition);
            }
        }
        // insertkey > parentKey1 && insertKey < parentKey2
        // the insert key at the middle of the 3-node parent key1 and key2
        else {
            if (targetNode.getParent().getKey2() > targetNode.getKey1()) {
                tempNode1 = create2NodeInternal(targetNode.getParent().getKey1(),
                        targetNode,
                        targetNode.getParent().getLeftChild(),
                        targetNode.getLeftChild(),
                        0);
                tempNode2 = create2NodeInternal(targetNode.getParent().getKey2(),
                        targetNode,
                        targetNode.getRightChild(),
                        targetNode.getParent().getRightChild(),
                        2);
                // pointing the children towards their respective parent after rearrangement
//                targetNode.getParent().setParent(targetNode.getParent().getParent());
                targetNode.setChildPos(targetNode.getParent().getChildPos());
                targetNode.setParent(targetNode.getParent().getParent());
                tempNode1.getParent().setLeftChild(tempNode1);
                tempNode2.getParent().setRightChild(tempNode2);
                tempNode1.getLeftChild().setParent(tempNode1);
                tempNode1.getRightChild().setParent(tempNode1);
                tempNode2.getRightChild().setParent(tempNode2);
                tempNode2.getLeftChild().setParent(tempNode2);
                // pointing the target node to its new children
//                targetNode.setLeftChild(tempNode1);
//                targetNode.setRightChild(tempNode2);
                // setting the childPos for all the rearranged nodes
                tempNode1.getLeftChild().setChildPos(0);
                tempNode1.getRightChild().setChildPos(2);
                tempNode2.getLeftChild().setChildPos(0);
                tempNode2.getRightChild().setChildPos(2);

                if (treeObj.getRoot().isRoot(preserveTargetNodeParent)) {
                    treeObj.setRoot(targetNode);
                } else {
                    setTargetNodePtr(preserveTargetNodeParent, targetNode, preservePosition);
                }
            }
            // insertKey > parentKey2
            // the insert key is on the right of the 3-node parent key2
            else {
                tempNode1 = create2NodeInternal(targetNode.getParent().getKey1(),
                        tempNode2,
                        targetNode.getParent().getLeftChild(),
                        targetNode.getParent().getMiddleChild(),
                        0);
                tempNode2 = create2NodeInternal(targetNode.getParent().getKey2(),
                        targetNode.getParent().getParent(),
                        tempNode1,
                        targetNode,
                        targetNode.getParent().getChildPos());
                // pointing children to parent
                tempNode1.setParent(tempNode2);
                tempNode2.setLeftChild(tempNode1);
                targetNode.setParent(tempNode2);
                tempNode1.getRightChild().setParent(tempNode1);
                tempNode1.getLeftChild().setParent(tempNode1);
                // setting the childPos
                targetNode.setChildPos(2);
                tempNode1.getLeftChild().setChildPos(0);
                tempNode1.getRightChild().setChildPos(2);

                if (treeObj.getRoot().isRoot(preserveTargetNodeParent)) {
                    treeObj.setRoot(tempNode2);
                } else {
                    setTargetNodePtr(preserveTargetNodeParent, tempNode2, preservePosition);
                }
            }
        }
        return tempNode1;
    }


    // ====================== split and promote functions ===================================


    private node setTargetNodePtr(node targetNode, node temp, int position) {
        // setting the left child
        if (position == 0) {
            targetNode.getParent().setLeftChild(temp);
        }
        // setting the right child
        else if (position == 2) {
            targetNode.getParent().setRightChild(temp);
        }
        // setting the middle child
        else {
            targetNode.getParent().setMiddleChild(temp);
        }
        return temp;
    }

    private node setTargetNodePtr(node targetNode, node temp) {
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
        return temp;
    }

    void setChildPos(node rt, int pos) {
        // set left child == 0
        if (pos == 0) {
            rt.getLeftChild().setChildPos(pos);
        }
        // set middle child == 1
        else if (pos == 1) {
            rt.getMiddleChild().setChildPos(pos);
        }
        // set right child == 2
        else {
            rt.getRightChild().setChildPos(pos);
        }
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
                    setChildPos(rt, 0);
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
                        setChildPos(rt, 1);
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
                        setChildPos(rt, 2);
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
                    setChildPos(rt, 0);
                    return addFindHelp(val, rt.getLeftChild(), treeObj);
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) {
                    setTargetLocation3Node(1);
                    return rt;
                } else {
                    setChildPos(rt, 2);
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
    void inorderTraverse(node rt) {
        if (rt == null) return;
        if (rt.isLeaf()) printNodeValues(rt);
        else if (!rt.is3node()) {
            inorderTraverse(rt.getLeftChild());
            printNodeValues(rt);
            inorderTraverse(rt.getRightChild());
        } else {
            inorderTraverse(rt.getLeftChild());
            printNodeValues(rt);
            inorderTraverse(rt.getMiddleChild());
            printNodeValues(rt);
            inorderTraverse(rt.getRightChild());
        }
    }

    @Override
    void preOrderTraverse(node rt) {
        if (rt == null) return;
        if (rt.isLeaf()) printNodeValues(rt);
        else if (!rt.is3node()) {
            printNodeValues(rt);
            preOrderTraverse(rt.getLeftChild());
            preOrderTraverse(rt.getRightChild());

        } else {
            printNodeValues(rt);
            preOrderTraverse(rt.getLeftChild());
            preOrderTraverse(rt.getMiddleChild());
            preOrderTraverse(rt.getRightChild());
        }
    }

    private void printNodeValues(node rt) {
        if (rt.is3node()) {
            System.out.print(rt.getKey1() + " " + rt.getKey2() + " ");
        } else {
            System.out.print(rt.getKey1() + " ");
        }
    }

    @Override
    node remove(int val) {
        removeInstructionCounterIncrement();
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
                if (rt.isLeaf()) {
                    return null;
                } else {
                    setChildPos(rt, 0);
                    return find(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                // going left of key2 - if insertKey less then key2
                if (val < checkKey2) {
                    comparisonsIncrement(1);
                    if (rt.isLeaf()) {
                        return null;
                    } else {
                        setChildPos(rt, 1);
                        return find(val, rt.getMiddleChild());
                    }
                }
                // going right of key2 - if insertKey greater then key2
                else if (val > checkKey2) {
                    comparisonsIncrement(2);
                    if (rt.isLeaf()) {
                        return null;
                    } else {
                        setChildPos(rt, 2);
                        return find(val, rt.getRightChild());
                    }
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
                if (rt.isLeaf()) {
                    return null;
                } else {
                    setChildPos(rt, 0);
                    return find(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) {
                    return null;
                } else {
                    setChildPos(rt, 2);
                    return find(val, rt.getRightChild());
                }
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
        threeNodeInstructionCounterIncrement();
        node newNode = new t23_3Node_Leaf();
        newNode.setKey1(key1);
        newNode.setKey2(key2);
        newNode.setParent(parent);
        newNode.setChildPos(childPos);
        return newNode;
    }

    public node create3NodeInternal(int key1, int key2, node parent,
                                    node left, node middle, node right, int childPos) {
        threeNodeInstructionCounterIncrement();
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

    // ====================== node creating function ===================================


}
