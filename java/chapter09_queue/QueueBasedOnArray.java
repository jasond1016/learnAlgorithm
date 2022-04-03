package chapter09_queue;

/**
 * 基于数组实现的顺序队列
 *
 * @author Jason
 * @date 2020/4/15
 */
public class QueueBasedOnArray {
    private String[] items;
    private int head = 0;
    private int tail = 0;
    private int capacity;

    public QueueBasedOnArray(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == capacity) {
            if (head == 0) {
                System.out.println("queue is full.");
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println("queue is empty.");
            return null;
        }
        return items[head++];
    }

    public void printAll() {
        System.out.println("==start==");
        for (int i = head; i <= tail - 1; i++) {
            System.out.print(" " + items[i]);
        }
        System.out.println("");
        System.out.println("===end===");
    }

    public static void main(String[] args) {
        QueueBasedOnArray queue = new QueueBasedOnArray(5);
        queue.printAll();
        queue.enqueue("1");
        queue.printAll();
        queue.enqueue("2");
        queue.printAll();
        queue.enqueue("3");
        queue.printAll();
        queue.enqueue("4");
        queue.printAll();
        queue.enqueue("5");
        queue.printAll();
        queue.enqueue("6");
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
        queue.enqueue("7");
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
        queue.enqueue("8");
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
        System.out.println(queue.dequeue());
        queue.printAll();
    }
}
