abstract class threeNodeLeaf extends node {
    // ====================== Member variables ===================================

    // int nodeIndex
    // int key1
    // int key2
    // node parent


    //    int[] key = new int[2];
    private int key1 = 0;
    private int key2 = 0;

    // ====================== Member variables ===================================

    // ====================== getters and setters ===================================

    @Override
    public int getKey1() {
        return key1;
    }

    @Override
    public void setKey1(int key1) {
        this.key1 = key1;
    }

    @Override
    public int getKey2() {
        return key2;
    }

    @Override
    public void setKey2(int key2) {
        this.key2 = key2;
    }


    // ====================== getters and setters ===================================

}
