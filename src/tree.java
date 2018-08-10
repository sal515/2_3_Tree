abstract class tree {


    // ====================== Member variables ===================================

    private static int comparisons = 0;

    private node root = null;

    private static int treeSize = 0;

    private stack stackObj = null;

    private boolean isKey2 = false;     // only used for find method

    private boolean found = false;     // only used for addFindHelp method

    private node addfindHelpReturnObj = null; // only used for addFindHelp method
    // ====================== Member variables ===================================

    tree() {
        root = null;
        treeSize = 0;
        stackObj = null;
        isKey2 = false;
    }

    // ====================== abstract member functions ===================================

    abstract boolean isEmpty(node rt);

    abstract int getSubTreeSize(node nodeObj);

    abstract node find(int val, node rt);

    abstract boolean add(int val, node rt);

    abstract boolean addHelp(int val, node rt);

    abstract node addFindHelp(int val, node rt);

    abstract node remove(int val);

    abstract void traverse();

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

    public boolean isKey2() {
        return isKey2;
    }

    public void setisKey2(boolean key2) {
        isKey2 = key2;
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

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public node getAddfindHelpReturnObj() {
        return addfindHelpReturnObj;
    }

    public void setAddfindHelpReturnObj(node addfindHelpReturnObj) {
        this.addfindHelpReturnObj = addfindHelpReturnObj;
    }

    // ====================== getters and setters ===================================

}
