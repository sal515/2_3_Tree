public class testClass {


    private static void t23outputTest(tree testAddtree) {
        System.out.print(testAddtree.getThreeNodeCounter());
        System.out.println(testAddtree.getAddInstructionCounter());
        System.out.println(testAddtree.getFindInstructionCounter());
        System.out.println(testAddtree.getRemoveInstructionCounter());
        testAddtree.preOrderTraverse(testAddtree.getRoot());
    }

    private static void buildAsstree(tree testAddtree) {
        testAddtree.add(280, testAddtree.getRoot(), testAddtree);
        testAddtree.add(563, testAddtree.getRoot(), testAddtree);
        testAddtree.add(82, testAddtree.getRoot(), testAddtree);
        testAddtree.add(529, testAddtree.getRoot(), testAddtree);
        testAddtree.add(500, testAddtree.getRoot(), testAddtree);
        testAddtree.add(900, testAddtree.getRoot(), testAddtree);
        testAddtree.add(794, testAddtree.getRoot(), testAddtree);
        t23Tree.findInstructionCounterIncrement();
        testAddtree.find(563, testAddtree.getRoot());
    }

    // testing purposes
    public static void checkAddFindHelper(tree treeObj, node addFindHelperNode) {
        if (!(addFindHelperNode == null)) {
            if (addFindHelperNode.is3node()) {
                System.out.println("Target Node with key1: " + addFindHelperNode.getKey1() + " key2 " +
                        addFindHelperNode.getKey2() + " comparisons : " + tree.getComparisons());
                System.out.println("3-node: " + addFindHelperNode.is3node());
                System.out.println("Target Location: " + treeObj.getTargetLocation3Node());
            } else {
                System.out.println("Target Node with key: " + addFindHelperNode.getKey1() +
                        " comparisons : " + tree.getComparisons());
                System.out.println("3-node: " + addFindHelperNode.is3node());
                System.out.println("Target Location: " + treeObj.getTargetLocation3Node());

            }
        } else System.out.println("key was found and Comaparisons: "
                + tree.getComparisons() + " null: " + (addFindHelperNode == null));


    }

    // final usage
    public static void handleFind(int testFinkKey, tree treeObj) {
        node temp = treeObj.find(testFinkKey, treeObj.getRoot());
        if (treeObj.isEmpty(treeObj.getRoot())) System.out.println("empty root");
//        if (temp == null) System.out.println("empty root");
        else if (temp.is3node()) {
            if (temp != null && treeObj.isKey2Find())
                System.out.println("Found key2: " + temp.getKey2() + " comparisons : " + tree.getComparisons());
            else if (temp != null && !treeObj.isKey2Find())
                System.out.println("Found key1: " + temp.getKey1() + " comparisons : " + tree.getComparisons());
            else System.out.println("not found");
        } else {
            if (temp != null) System.out.println("Found key: " +
                    temp.getKey1() + " comparisons : " + tree.getComparisons());
            else System.out.println("not found");
        }
    }

    // testing purposes
    public static void testhandleFind(tree treeObj, int testFinkKey) {
        node temp = treeObj.find(testFinkKey, treeObj.getRoot());
        if (treeObj.isEmpty(treeObj.getRoot())) System.out.println("empty root");
        else if (temp.is3node()) {
            if (temp != null) System.out.println("Found key1: " + temp.getKey1() + " key2 " +
                    temp.getKey2() + " comparisons : " + tree.getComparisons());
            else System.out.println("not found");
        } else {
            if (temp != null) System.out.println("Found key1: " +
                    temp.getKey1() + " comparisons : " + tree.getComparisons());
            else System.out.println("not found");
        }
    }

    public static tree testTreeStep7() {
        tree testTree = new t23Tree();
        node troot = new t23_2Node_Internal();
        node l1childright = new t23_2Node_Internal();
        node l1childleft = new t23_2Node_Internal();
        node l2childrightl1 = new t23_2Node_Leaf();
        node l2childleftl1 = new t23_2Node_Leaf();
        node l2childleftl2 = new t23_2Node_Leaf();
        node l2childrightl2 = new t23_2Node_Leaf();
        // setting root
        testTree.setRoot(troot);
        testTree.getRoot().setKey1(529);
        testTree.getRoot().setParent(null);
        // setting leftchild of root
        testTree.getRoot().setLeftChild(l1childleft);
        testTree.getRoot().getLeftChild().setKey1(280);
        testTree.getRoot().getLeftChild().setParent(testTree.getRoot());
        // setting rightchild of root
        testTree.getRoot().setRightChild(l1childright);
        testTree.getRoot().getRightChild().setKey1(794);
        testTree.getRoot().getRightChild().setParent(testTree.getRoot());
        // setting leftchild of leftchild of root
        testTree.getRoot().getLeftChild().setLeftChild(l2childleftl1);
        testTree.getRoot().getLeftChild().getLeftChild().setKey1(82);
        testTree.getRoot().getLeftChild().getLeftChild().setParent(testTree.getRoot().getLeftChild());
        // setting rightchild of left child of root
        testTree.getRoot().getLeftChild().setRightChild(l2childrightl1);
        testTree.getRoot().getLeftChild().getRightChild().setKey1(500);
        testTree.getRoot().getLeftChild().getRightChild().setParent(testTree.getRoot().getLeftChild());
        // setting leftchild of rightchild of root
        testTree.getRoot().getRightChild().setLeftChild(l2childleftl2);
        testTree.getRoot().getRightChild().getLeftChild().setKey1(563);
        testTree.getRoot().getRightChild().getLeftChild().setParent(testTree.getRoot().getRightChild());
        // setting rightchild of rightchild of root
        testTree.getRoot().getRightChild().setRightChild(l2childrightl2);
        testTree.getRoot().getRightChild().getRightChild().setKey1(900);
        testTree.getRoot().getRightChild().getRightChild().setParent(testTree.getRoot().getRightChild());

        return testTree;
    }

    public static tree testTreeStep6() {
        tree testTree = new t23Tree();
        node troot = new t23_3Node_Internal();
        node trchild = new t23_3Node_Leaf();
        node tmChild = new t23_2Node_Leaf();
        node tlchild = new t23_2Node_Leaf();
        testTree.setRoot(troot);
        testTree.getRoot().setKey1(280);
        testTree.getRoot().setKey2(529);
        testTree.getRoot().setParent(null);
        testTree.getRoot().setLeftChild(tlchild);
        testTree.getRoot().getLeftChild().setKey1(82);
        testTree.getRoot().getLeftChild().setParent(testTree.getRoot());
        testTree.getRoot().setRightChild(trchild);
        testTree.getRoot().getRightChild().setKey1(563);
        testTree.getRoot().getRightChild().setKey2(900);
        testTree.getRoot().getRightChild().setParent(testTree.getRoot());
        testTree.getRoot().setMiddleChild(tmChild);
        testTree.getRoot().getMiddleChild().setKey1(500);
        testTree.getRoot().getMiddleChild().setParent(testTree.getRoot());

        return testTree;

    }



}
