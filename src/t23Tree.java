public class t23Tree extends tree {

    // ====================== Member variables ===================================

    // node root
    // int size
    // stack stackObj

    // ====================== Member variables ===================================

    // ====================== Member functions ===================================

    @Override
    node addFindHelp(int val, node rt) {
        node addfindHelpReturnObj;
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
                    setFound(false);
                    return (addfindHelpReturnObj = rt);
                } else {
                    return find(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                // going left of key2 - if insertKey less then key2
                if (val < checkKey2) {
                    comparisonsIncrement(1);
                    if (rt.isLeaf()) {
                        setFound(false);
                        return (addfindHelpReturnObj = rt);
                    } else {
                        return find(val, rt.getMiddleChild());
                    }
                }
                // going right of key2 - if insertKey greater then key2
                else if (val > checkKey2) {
                    comparisonsIncrement(2);
                    if (rt.isLeaf()) {
                        setFound(false);
                        return (addfindHelpReturnObj = rt);
                    } else {
                        return find(val, rt.getRightChild());
                    }
                }
                // key is the key2 of 3 node
                else {
                    setFound(true);
                    comparisonsIncrement(2);
                    setisKey2(true);
                    return rt;
                }
            }
            // key is the key1 of 3 node
            else {
                setFound(true);
                comparisonsIncrement(2);
                setisKey2(false);
                return rt;
            }
        }
        // if 2-node - do following:
        else {
            // going Left of key1 - if insertKey less then key1
            if (val < checkKey1) {
                comparisonsIncrement(1);
                if (rt.isLeaf()) {
                    setFound(false);
                    return (addfindHelpReturnObj = rt);
                } else {
                    return find(val, rt.getLeftChild());
                }
                // going right of key1 - if insertKey greater then key1
            } else if (val > checkKey1) {
                comparisonsIncrement(2);
                if (rt.isLeaf()) {
                    setFound(false);
                    return (addfindHelpReturnObj = rt);
                } else {
                    return find(val, rt.getRightChild());
                }
            }
            // key is the key1 of 2-node
            else {
                setFound(true);
                comparisonsIncrement(2);
                setisKey2(false);
                return rt;
            }
        }
    }


    @Override
    boolean addHelp(int val, node rt) {
        return false;
    }



    @Override
    int getSubTreeSize(node nodeObj) {
        return 0;
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
    node remove(int val) {
        return null;
    }

    @Override
    void traverse() {

    }

    @Override
    void traverse(node rt) {

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
                    setisKey2(true);
                    return rt;
                }
            }
            // key is the key1 of 3 node
            else {
                comparisonsIncrement(2);
                setisKey2(false);
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
                setisKey2(false);
                return rt;
            }
        }
    }


    // ====================== Member functions ===================================
}
