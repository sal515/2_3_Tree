public class RedBlack_Tree extends tree {

    public node rotateRight(node target) {
        return target;
    }

    public node rotateLeft(node target) {
        return target;
    }

    public node invertColor(node target) {
        return target;
    }

    @Override
    boolean isEmpty(node rt) {
        return false;
    }

    @Override
    node find(int val, node rt) {

        node temp = null;
        temp = rotateLeft(rt);
        temp.setParent(rt);
        temp.getKey2();
        temp = rotateRight(rt);
        temp.setKey2(val);

        return null;
    }

    @Override
    boolean add(int val, node rt, tree treeObj) {
        RedBlack_Tree treeOb = new RedBlack_Tree();
        node temp1 = new RedBlack_2Node_internal();
        node temp2 = new RedBlack_2node_leaf();


        if (temp1 == temp2) {
            treeOb.invertColor(temp1);
        } else {
            ((RedBlack_2node_leaf) temp2).setColor(false);

        }
        return false;
    }

    @Override
    node addFindHelp(int val, node rt, tree treeObj) {
        return null;
    }

    @Override
    node remove(int val) {
        RedBlack_Tree tree = new RedBlack_Tree();
        node temp1 = new RedBlack_2Node_internal();
        if (((RedBlack_2Node_internal) temp1).isRed()) {
            ((RedBlack_2Node_internal) temp1).setColor(false);
        }
        return null;
    }

    @Override
    void inorderTraverse(node rt) {

    }

    @Override
    void preOrderTraverse(node rt) {

    }
}
