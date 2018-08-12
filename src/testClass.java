import java.util.Random;

public class testClass {
    // =========== Member variables ======================
    static int leftheight = 0;
    static int rightheight = 0;
    // ----------------------------------------------


    public static int[] TestRandomInputs(int size) {
        Random objRandom = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = objRandom.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }





    public static void orderTraversal(node rt) {
        int leftH = leftHeight(rt);
        int rightH = rightHeight(rt);
        int i;
        if (leftH == rightH) {
            for (i = 0; i <= leftH; i++) {
                printTreeInLevels(rt, i);
                System.out.println();
            }
        }
    }

    private static void printTreeInLevels(node rt, int i) {
        if (rt == null) {
            return;
        }
        if (rt.isLeaf()) {
            if (rt.is3node()) {
                System.out.print("|=> " + rt.getKey1() + " " + rt.getKey2() + " <=| ");
            } else {
                System.out.print("|=> " + rt.getKey1() + " <=| ");
            }
            return;
        }
        if (i == 1) {
            if (rt.is3node()) {
                System.out.print("|=> " + rt.getKey1() + " " + rt.getKey2() + " <=| ");
            } else {
                System.out.print("|=> " + rt.getKey1() + " <=| ");
            }
        } else if (i > 1) {
            if (rt.is3node()) {
                printTreeInLevels(rt.getLeftChild(), i - 1);
                printTreeInLevels(rt.getMiddleChild(), i - 1);
                printTreeInLevels(rt.getRightChild(), i - 1);
            } else {
                printTreeInLevels(rt.getLeftChild(), i - 1);
                printTreeInLevels(rt.getRightChild(), i - 1);
            }
        }
    }

    public static int leftHeight(node rt) {
        if (rt == null) return 0;
        if (rt.isLeaf()) {
            leftheight++;
        } else {
            leftheight++;
            leftHeight(rt.getLeftChild());
        }
        return leftheight;
    }

    public static int rightHeight(node rt) {
        if (rt == null) return 0;
        if (rt.isLeaf()) {
            rightheight++;
        } else {
            rightheight++;
            rightHeight(rt.getRightChild());
        }
        return rightheight;
    }

    public static void graphicalTraversal(node rt) {
        if (rt == null) return;
        if (rt.isLeaf()) printGraphicaltree(rt);
        else if (!rt.is3node()) {
            printGraphicaltree(rt);
            graphicalTraversal(rt.getLeftChild());
            graphicalTraversal(rt.getRightChild());

        } else {
            printGraphicaltree(rt);
            graphicalTraversal(rt.getLeftChild());
            graphicalTraversal(rt.getMiddleChild());
            graphicalTraversal(rt.getRightChild());
        }
    }

    private static void printGraphicaltree(node rt) {
        if (rt.is3node()) {
            if (rt.isRoot(rt)) {
                System.out.println("rt-" + rt.getKey1() + " " + rt.getKey2() + "-rt ");
            } else if (rt.isLeaf()) {
                System.out.println("lf-" + rt.getKey1() + " " + rt.getKey2() + "-lf ");
            } else {
                System.out.print(rt.getKey1() + " " + rt.getKey2() + " ");
            }
        } else {
            if (rt.isRoot(rt)) {
                System.out.println("rt-" + rt.getKey1() + "-rt ");
            } else if (rt.isLeaf()) {
                System.out.println("lf-" + rt.getKey1() + "-lf ");
            } else {
                System.out.print(rt.getKey1() + " ");
            }
        }
    }

    public static tree allThreeNode2Leves(tree treeobj) {

//        usage-----------------------------

//        // test 2 levels of all 3 nodes
//        tree treeobj2 = new t23Tree();
//        testClass.allThreeNode2Leves(treeobj2);
//        testClass.orderTraversal(treeobj2.getRoot());
//        System.out.println();
//        treeobj2.add(302, treeobj2.getRoot(), treeobj2);
//        testClass.orderTraversal(treeobj2.getRoot());


        // root
        treeobj.setRoot(((t23Tree) treeobj).create3NodeInternal(200, 400, null,
                null, null, null, -1));
        // leftchild - root
        treeobj.getRoot().setLeftChild(((t23Tree) treeobj).create3NodeLeaf(100, 150, treeobj.getRoot(),
                 0));
        // middlechild - root
        treeobj.getRoot().setMiddleChild(((t23Tree) treeobj).create3NodeLeaf(250, 350, treeobj.getRoot(),
                 1));
        // rightchild - root
        treeobj.getRoot().setRightChild(((t23Tree) treeobj).create3NodeLeaf(500, 800, treeobj.getRoot(),
                 2));



        return treeobj;
    }


    public static tree allThreeNode3Leves(tree treeobj) {
        // usage ----------------------------
//        */
        // test 3 levels of all 3 nodes
//        tree treeobj = new t23Tree();
//        testClass.allThreeNode3Leves(treeobj);
//        testClass.orderTraversal(treeobj.getRoot());
//        System.out.println();
//        treeobj.add(302, treeobj.getRoot(), treeobj);
//        testClass.orderTraversal(treeobj.getRoot());

        // usage ----------------------------


        // root
        treeobj.setRoot(((t23Tree) treeobj).create3NodeInternal(200, 400, null,
                null, null, null, -1));
        // leftchild - root
        treeobj.getRoot().setLeftChild(((t23Tree) treeobj).create3NodeInternal(100, 150, treeobj.getRoot(),
                null, null, null, 0));
        // middlechild - root
        treeobj.getRoot().setMiddleChild(((t23Tree) treeobj).create3NodeInternal(250, 350, treeobj.getRoot(),
                null, null, null, 1));
        // rightchild - root
        treeobj.getRoot().setRightChild(((t23Tree) treeobj).create3NodeInternal(500, 800, treeobj.getRoot(),
                null, null, null, 2));

        // leftchild - leftchild - root
        treeobj.getRoot().getLeftChild().setLeftChild(((t23Tree) treeobj).create3NodeLeaf(10, 50, treeobj.getRoot().getLeftChild(), 0));
        // middle - leftchild - root
        treeobj.getRoot().getLeftChild().setMiddleChild(((t23Tree) treeobj).create3NodeLeaf(125, 130, treeobj.getRoot().getLeftChild(), 1));
        // right - leftchild - root
        treeobj.getRoot().getLeftChild().setRightChild(((t23Tree) treeobj).create3NodeLeaf(155, 160, treeobj.getRoot().getLeftChild(), 2));

        // leftchild - middlechild - root
        treeobj.getRoot().getMiddleChild().setLeftChild(((t23Tree) treeobj).create3NodeLeaf(230, 240, treeobj.getRoot().getMiddleChild(), 0));
        // middlechild - middlechild - root
        treeobj.getRoot().getMiddleChild().setMiddleChild(((t23Tree) treeobj).create3NodeLeaf(300, 320, treeobj.getRoot().getMiddleChild(), 1));
        // rightchidl - middlechild - root
        treeobj.getRoot().getMiddleChild().setRightChild(((t23Tree) treeobj).create3NodeLeaf(375, 385, treeobj.getRoot().getMiddleChild(), 2));

        // left - rightchild  - root
        treeobj.getRoot().getRightChild().setLeftChild(((t23Tree) treeobj).create3NodeLeaf(430, 450, treeobj.getRoot().getRightChild(), 0));
        // middle - rightchild  - root
        treeobj.getRoot().getRightChild().setMiddleChild(((t23Tree) treeobj).create3NodeLeaf(600, 700, treeobj.getRoot().getRightChild(), 1));
        // right - rightchild  - root
        treeobj.getRoot().getRightChild().setRightChild(((t23Tree) treeobj).create3NodeLeaf(900, 950, treeobj.getRoot().getRightChild(), 2));

        return treeobj;
    }


    public static void t23outputTest(tree testAddtree) {
        System.out.print(testAddtree.getThreeNodeCounter());
        System.out.println(testAddtree.getAddInstructionCounter());
        System.out.println(testAddtree.getFindInstructionCounter());
        System.out.println(testAddtree.getRemoveInstructionCounter());
        testAddtree.preOrderTraverse(testAddtree.getRoot());
    }

    public static void buildAsstree(tree testAddtree) {
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
