import inputManagerPackage.inputManager;
import inputManagerPackage.operationsQueue;

// ====================== Member variables ===================================
// ====================== abstract member functions ===================================
// ====================== member functions ===================================
// ====================== getters and setters ===================================


class TwoThree {

    public static void main(String[] args) {
        // write your code here

        operationsQueue operationsQueueObj = inputManager.instructionExtractor("test.txt");
//        inputManagerPackage.inputManager.testPrintAllChar("test.txt");

//        inputManagerPackage.operationsQueue operationsQueueObj = inputManagerPackage.inputManager.instructionExtractor("OperationsOLD.txt");
//        inputManagerPackage.inputManager.testPrintAllChar("OperationsOLD.txt");

// testing with manual tree made by me -- from the assignment provided example
        tree treeObj;
        treeObj = testTreeStep6();
//        treeObj = testTreeStep7();


// testing add function
        int findVal = 890;
        treeObj.addHelp(findVal, treeObj.getRoot());



        int unnecessary = 9999;


// testing add - find helper function - target node locator
//        node addFindHelperNode = treeObj.addFindHelp(findVal, treeObj.getRoot());
//        checkAddFindHelper(treeObj, addFindHelperNode);


// testing how to initialize nodes easily
//        node parent = new t23_3Node_Internal();
//        node parent = new t23_3Node_Internal();
//        parent = node.initializeNode(parent, null, new t23_3Node_Leaf(),
//                new t23_2Node_Leaf(), new t23_2Node_Leaf(), 280, 529);


// testing how to recognize the value found
//        int testFinkKey = 900;
//        testhandleFind(treeObj, testFinkKey);
//        handleFind(testFinkKey, treeObj);


// random checks - to learn theory - unrelated to assignment

//        testClass.charExtractor("test.txt", operationsQueueObj);
//        testClass.charExtractor("Operations.txt");
//        testClass.charExtractor("OperationsOLD.txt");

    }

    private static void checkAddFindHelper(tree treeObj, node addFindHelperNode) {
        if (!(addFindHelperNode == null)) {
            if (addFindHelperNode.is3node()) {
                System.out.println("Target Node with key1: " + addFindHelperNode.getKey1() + " key2 " +
                        addFindHelperNode.getKey2() + " comparisons : " + treeObj.getComparisons());
                System.out.println("3 node: " + addFindHelperNode.is3node());
            } else {
                System.out.println("Target Node with key: " + addFindHelperNode.getKey1() +
                        " comparisons : " + treeObj.getComparisons());
                System.out.println("3 node: " + addFindHelperNode.is3node());
            }
        } else System.out.println("key was found and Comaparisons: "
                + treeObj.getComparisons() + " null: " + (addFindHelperNode == null));


    }

    private static void handleFind(int testFinkKey, tree treeObj) {
        node temp = treeObj.find(testFinkKey, treeObj.getRoot());
        if (treeObj.isEmpty(treeObj.getRoot())) System.out.println("empty root");
//        if (temp == null) System.out.println("empty root");
        else if (temp.is3node()) {
            if (temp != null && treeObj.isKey2Find())
                System.out.println("Found key2: " + temp.getKey2() + " comparisons : " + treeObj.getComparisons());
            else if (temp != null && !treeObj.isKey2Find())
                System.out.println("Found key1: " + temp.getKey1() + " comparisons : " + treeObj.getComparisons());
            else System.out.println("not found");
        } else {
            if (temp != null) System.out.println("Found key: " +
                    temp.getKey1() + " comparisons : " + treeObj.getComparisons());
            else System.out.println("not found");
        }
    }

    private static void testhandleFind(tree treeObj, int testFinkKey) {
        node temp = treeObj.find(testFinkKey, treeObj.getRoot());
        if (treeObj.isEmpty(treeObj.getRoot())) System.out.println("empty root");
        else if (temp.is3node()) {
            if (temp != null) System.out.println("Found key1: " + temp.getKey1() + " key2 " +
                    temp.getKey2() + " comparisons : " + treeObj.getComparisons());
            else System.out.println("not found");
        } else {
            if (temp != null) System.out.println("Found key1: " +
                    temp.getKey1() + " comparisons : " + treeObj.getComparisons());
            else System.out.println("not found");
        }
    }

    private static tree testTreeStep7() {
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

    private static tree testTreeStep6() {
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
