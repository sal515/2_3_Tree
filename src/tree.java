abstract class tree {


    // ====================== Member variables ===================================

    private static int comparisons = 0;

    private node root = null;

    private static int treeSize = 0;

    private stack stackObj = null;

    private boolean isKey2Find = false;     // only used for find method


    // eg. of a 3node
    // keys are:                10 20
    // target locations are :  0  1  2
    // target location default is -1
    // name of the variable for target location: targetLocation3Node
    // target location can be int from 0 to 2 depending on the location
    private int targetLocation3Node = -1;     // only used for addfindhelp method

//    private boolean found = false;     // only used for addFindHelp method

//    private node addfindHelpReturnObj = null; // only used for addFindHelp method
    // ====================== Member variables ===================================

    tree() {
        root = null;
        treeSize = 0;
        stackObj = null;
        isKey2Find = false;
    }

    // ====================== abstract member functions ===================================

    abstract boolean isEmpty(node rt);

    abstract int getSubTreeSize(node nodeObj);

    abstract node find(int val, node rt);

    abstract boolean add(int val, node rt);

    abstract boolean addHelp(int val, node rt, tree treeObj);

    abstract node addFindHelp(int val, node rt);

    abstract node remove(int val);

//    abstract void traverse();

    abstract void traverse(node rt);


    // ====================== abstract member functions ===================================

    // ====================== getters and setters ===================================
    public node getRoot() {
        return root;
    }

    public void setRoot(node root) {
        this.root = root;
    }

    public static void setTreeSize(int treeSize) {
        tree.treeSize = treeSize;
    }

    public static int getTreeSize() {
        return treeSize;
    }

    public void setStackObj(stack stackObj) {
        this.stackObj = stackObj;
    }

    public stack getStackObj() {
        return stackObj;
    }

    public boolean isKey2Find() {
        return isKey2Find;
    }

    public void setisKey2Find(boolean key2) {
        isKey2Find = key2;
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static void setComparisons(int comparisons) {
        tree.comparisons = comparisons;
    }

    public static void comparisonsIncrement(int number) {
        tree.setComparisons(tree.getComparisons() + number);
    }

    public int getTargetLocation3Node() {
        return targetLocation3Node;
    }

    public void setTargetLocation3Node(int targetLocation3Node) {
        this.targetLocation3Node = targetLocation3Node;
    }

    //    public boolean isFound() {
//        return found;
//    }

//    public void setFound(boolean found) {
//        this.found = found;
//    }

//    public node getAddfindHelpReturnObj() {
//        return addfindHelpReturnObj;
//    }

//    public void setAddfindHelpReturnObj(node addfindHelpReturnObj) {
//        this.addfindHelpReturnObj = addfindHelpReturnObj;
//    }

    // ====================== getters and setters ===================================

}
