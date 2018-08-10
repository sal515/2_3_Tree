public class t23Tree extends tree {

    // ====================== Member variables ===================================

    // node root
    // int size
    // stack stackObj

    // ====================== Member variables ===================================

    // ====================== Member functions ===================================

    // returns null if insert value is found
    @Override
    node addFindHelp(int val, node rt) {
        node addfindHelpReturnObj;

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
//                    setFound(false);
                    setTargetLocation3Node(0);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                // going left of key2 - if insertKey less then key2
                if (val < checkKey2) {
                    comparisonsIncrement(1);
                    if (rt.isLeaf()) {
                        setTargetLocation3Node(1);
//                        setFound(false);
                        return rt;
                    } else {
                        return addFindHelp(val, rt.getMiddleChild());
                    }
                }
                // going right of key2 - if insertKey greater then key2
                else if (val > checkKey2) {
                    comparisonsIncrement(2);
                    if (rt.isLeaf()) {
                        setTargetLocation3Node(2);
//                        setFound(false);
                        return rt;
                    } else {
                        return addFindHelp(val, rt.getRightChild());
                    }
                }
                // key is the key2 of 3 node
                else {
//                    setFound(true);
                    comparisonsIncrement(2);
                    setisKey2Find(true);
                    return null;
                }
            }
            // key is the key1 of 3 node
            else {
//                setFound(true);
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
//                    setFound(false);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) {
//                    setFound(false);
                    return rt;
                } else {
                    return addFindHelp(val, rt.getRightChild());
                }
            }
            // key is the key1 of 2-node
            else {
//                setFound(true);
                comparisonsIncrement(2);
                setisKey2Find(false);
                return null;
            }
        }
    }


    @Override
    boolean addHelp(int val, node rt, tree treeObj) {
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

        return false;
    }

    @Override
    boolean add(int val, node rt) {
        if (find(val, rt) != null) {
            return true;
        } else {
        }


        return false;
    }

    @Override
    void traverse(node rt) {

    }

    @Override
    int getSubTreeSize(node nodeObj) {
        return 0;
    }

    @Override
    node remove(int val) {
        return null;
    }

    @Override
    boolean isEmpty(node rt) {
        if (rt == null) return true;
        else return false;
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
