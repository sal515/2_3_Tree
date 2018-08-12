public class instructions {
    private char operator;
    private int key;

    public instructions() {
        this.operator = 'n';
        this.key = -1;
    }

    public instructions(instructions obj2copy) {
        this.operator = obj2copy.getOperator();
        this.key = obj2copy.getKey();
    }

    public instructions(char operator, int key) {
        this.operator = operator;
        this.key = key;
    }


    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
