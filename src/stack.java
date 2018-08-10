public class stack {
    // ====================== Member variables ===================================

    private node[] stackArr;
    private int stackPtr;
    private int stackSize;

    // ====================== Member variables ===================================


    // ====================== member functions ===================================

    public stack(int size) {
        this.stackSize = size;
        this.stackArr = new node[size];
        this.stackPtr = -1;
    }

    void push(node nodeObj) {
        if (!isFull()) {
            this.stackArr[++stackPtr] = nodeObj;
        }
    }

    node pop() {
        if (!isEmpty()) {
            return this.stackArr[stackPtr--];
        } else return null;
    }

    private boolean isEmpty() {
        return (stackPtr == -1);
    }

    private boolean isFull() {
        return stackPtr == (getStackPtr() - 1);
    }

    node peekTop() {
        if (!isEmpty()) {
            return this.stackArr[stackPtr];
        } else return null;
    }

    // ====================== member functions ===================================


    // ====================== getters and setters ===================================

    public node[] getStackArr() {
        return stackArr;
    }

    public void setStackArr(node[] stackArr) {
        this.stackArr = stackArr;
    }

    public int getStackPtr() {
        return stackPtr;
    }

    public void setStackPtr(int stackPtr) {
        this.stackPtr = stackPtr;
    }


    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    // ====================== getters and setters ===================================

}
