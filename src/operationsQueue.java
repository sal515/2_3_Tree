public class operationsQueue {
    private final instructions[] queue;
    private int head;
    private int tail;


    public operationsQueue() {
        this.head = 0;
        this.tail = 0;
        queue = new instructions[100];
        System.out.println("Queue of default size 100 was created!");
    }

    public operationsQueue(int queueSize) {
        this.head = 0;
        this.tail = 0;
        queue = new instructions[queueSize];
    }

    public boolean isEmpty() {
        return (head == tail);
    }

    public boolean isFull() {
        return (tail == queue.length);
    }

    public void enqueue(instructions obj) {
        if (!isFull()) {
            queue[tail] = obj;
            tail++;
        } else {
            System.out.println("Queue filled up.");
        }
    }

    public instructions denqueue() {
        if (!isEmpty()) {
            instructions returnObj;
            returnObj = queue[head];
            head++;
            return returnObj;
        } else {
            System.out.println("Queue is empty.");
            return null;
        }
    }

}
