package chapter07_linkedlist;

class JosephQuiz {
    public static void main(String[] args) {
        int total = 10;
        int length = 1;
        int start = 1;
        boolean clockwise = true;

        if (length == 1) {
            if (clockwise == true) {
                System.out.println(total);
            } else {
                System.out.println(start + 1);
            }
            return;
        }
        Node startNode = createLinkList(total, start, clockwise);
        Node preNode = null;
        Node currNode = startNode;
        while (currNode.next != currNode) {
            for (int j = 0; j < length - 1; j++) {
                preNode = currNode;
                currNode = currNode.next;
            }
            preNode.next = currNode.next;
            currNode.next = null;
            currNode = preNode.next;
        }
        System.out.println("answer: " + currNode.value);
    }

    static Node createLinkList(int n, int start, boolean clockwise) {
        Node head = new Node(1);
        Node startNode = head;
        Node pre = head;

        if (clockwise) {
            for (int i = 2; i <= n; i++) {
                Node newNode = new Node(i);
                if (i == start) {
                    startNode = newNode;
                }
                pre.next = newNode;
                pre = newNode;
            }
        } else {
            for (int i = n; i >= 2; i--) {
                Node newNode = new Node(i);
                if (i == start) {
                    startNode = newNode;
                }
                pre.next = newNode;
                pre = newNode;
            }
        }
        pre.next = head;
        return startNode;
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    Node add(Node node) {
        this.next = node;
        return this;
    }
}
