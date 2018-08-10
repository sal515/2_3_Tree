abstract class twoNodeLeaf extends node {

    // ====================== Member variables ===================================
    // int nodeIndex
    // int key1
    // node parent


    private int key1 = 0;


    // ====================== Member variables ===================================

    // ====================== getters and setters ===================================

    @Override
    public void setKey1(int key1) {
        this.key1 = key1;
    }


    @Override
    public int getKey1() {
        return key1;
    }

    // ====================== getters and setters ===================================

}
