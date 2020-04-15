package queue;

/**
 * 基于数组实现的循环队列
 *
 * @author Jason
 * @date 2020/4/15
 */
public class CircularQueue {
    private String[] items;
    private int head;
    private int tail;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String data) {
        if ((tail + 1) % capacity == head) {
            System.out.println("queue is full.");
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println("queue is empty.");
            return null;
        }
        String data = items[head];
        head = (head + 1) % capacity;
        return data;
    }

    public void printAll() {
        System.out.println("==start==");
        int p = head;
        for (int i = head; i % capacity != tail; i++) {
            System.out.print(items[i % capacity] + " ");
        }
        System.out.println();
        System.out.println("===end===");
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(0);
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
        System.out.println(queue.dequeue());
    }
}
