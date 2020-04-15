package stack;

/**
 * @author Jason
 * @date 2020/4/14
 */
public class StackBasedOnLinkedList {
    private Node top;

    void push(String data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    String pop() {
        if (top == null) {
            return null;
        }
        String data = this.top.data;
        top = top.next;
        return data;
    }

    void printAll() {
        System.out.println("==start==");
        Node p = top;
        if (p == null) {
            System.out.println("nothing here.");
        }
        while (p != null) {
            System.out.print(" " + p.data);
            p = p.next;
        }
        System.out.println("");
        System.out.println("===end===");
    }

    class Node {
        private String data;
        private Node next;

        Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push("1");
        stack.printAll();
        stack.push("2");
        stack.printAll();
        stack.push("3");
        stack.printAll();
        stack.push("4");
        stack.printAll();
        stack.push("5");
        stack.printAll();
        stack.push("6");
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
    }
}
