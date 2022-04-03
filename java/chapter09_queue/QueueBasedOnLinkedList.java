package chapter09_queue;

/**
 * 基于链表实现的链式队列
 *
 * @author Jason
 * @date 2020/4/15
 */
public class QueueBasedOnLinkedList {
    private Node headNode;
    private Node tailNode;

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
            tailNode = headNode;
            return;
        }
        tailNode.next = newNode;
        tailNode = tailNode.next;
    }

    public String dequeue() {
        if (headNode == null) {
            System.out.println("queue is empty.");
            return null;
        }
        String data = headNode.data;
        headNode = headNode.next;
        return data;
    }

    public void printAll() {
        System.out.println("==start==");
        Node tmp = headNode;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
        System.out.println("===end===");
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.printAll();
        queue.dequeue();
        queue.enqueue("1");
        queue.printAll();
        queue.dequeue();
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

    class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

    }
}
