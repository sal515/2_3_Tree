abstract class tree {

    // ====================== Member variables ===================================

    private static int comparisons = 0;

    private node root = null;

    private boolean isKey2Find = false;     // only used for find method

    private static int addInstructionCounter = 0;
    private static int findInstructionCounter = 0;
    private static int removeInstructionCounter = 0;
    private static int threeNodeCounter = 0;
    private static int instructionsCounter = 0;


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
        isKey2Find = false;
    }

    // ====================== abstract member functions ===================================

    abstract boolean isEmpty(node rt);

    abstract node find(int val, node rt);

    abstract boolean add(int val, node rt, tree treeObj);

    abstract node addFindHelp(int val, node rt, tree treeObj);

    abstract node remove(int val);

    abstract void inorderTraverse(node rt);

    abstract void preOrderTraverse(node rt);


    // ====================== abstract member functions ===================================

    // ====================== getters and setters ===================================
    public node getRoot() {
        return root;
    }

    public void setRoot(node root) {
        this.root = root;
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

    public static int getAddInstructionCounter() {
        return addInstructionCounter;
    }

    public static void setAddInstructionCounter(int addInstructionCounter) {
        tree.addInstructionCounter = addInstructionCounter;
    }

    public static int getFindInstructionCounter() {
        return findInstructionCounter;
    }

    public static void setFindInstructionCounter(int findInstructionCounter) {
        tree.findInstructionCounter = findInstructionCounter;
    }

    public static int getRemoveInstructionCounter() {
        return removeInstructionCounter;
    }

    public static void setRemoveInstructionCounter(int removeInstructionCounter) {
        tree.removeInstructionCounter = removeInstructionCounter;
    }

    public static int getThreeNodeCounter() {
        return threeNodeCounter;
    }

    public static void setThreeNodeCounter(int threeNodeCounter) {
        tree.threeNodeCounter = threeNodeCounter;
    }

    public static void addInstructionCounterIncrement() {
        tree.setAddInstructionCounter(tree.getAddInstructionCounter() + 1);
    }

    public static void findInstructionCounterIncrement() {
        tree.setFindInstructionCounter(tree.getFindInstructionCounter() + 1);
    }

    public static void removeInstructionCounterIncrement() {
        tree.setRemoveInstructionCounter(tree.getRemoveInstructionCounter() + 1);
    }

    public static void threeNodeInstructionCounterIncrement() {
        tree.setThreeNodeCounter(tree.getThreeNodeCounter() + 1);
    }

    public static int getInstructionsCounter() {
        return instructionsCounter;
    }

    public static void setInstructionsCounter(int instructionsCounter) {
        tree.instructionsCounter = instructionsCounter;
    }

    public static void instructionCounterIncrement() {
        tree.setInstructionsCounter(tree.getInstructionsCounter() + 1);
    }

    // ====================== getters and setters ===================================

}
