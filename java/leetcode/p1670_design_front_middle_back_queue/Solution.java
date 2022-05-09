package leetcode.p1670_design_front_middle_back_queue;

public class Solution {
    public static void main(String[] args) {
        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        obj.pushFront(1);
        obj.pushBack(2);
        obj.pushMiddle(3);
        obj.pushMiddle(4);
        System.out.println(obj.popMiddle());
        System.out.println(obj.popMiddle());
        System.out.println(obj.popBack());
        System.out.println(obj.popFront());
    }
}

class FrontMiddleBackQueue {
    private Node frontNode;
    private Node backNode;
    private Node middleNode;
    private int size;

    private class Node {
        int val;
        Node previous;
        Node next;

        public Node(int val) {
            this.val = val;
        }

    }

    public FrontMiddleBackQueue() {
        frontNode = new Node(-1);
        backNode = new Node(-1);
        frontNode.next = backNode;
        backNode.previous = frontNode;
    }

    public void pushFront(int val) {
        Node curr = new Node(val);
        curr.next = frontNode.next;
        curr.previous = frontNode;
        frontNode.next.previous = curr;
        frontNode.next = curr;
        size++;

        if (size == 1) {
            middleNode = curr;
        } else if (size % 2 == 0) {
            middleNode = middleNode.previous;
        }
    }

    public void pushMiddle(int val) {
        Node curr = new Node(val);
        if (size == 0) {
            curr.previous = frontNode;
            curr.next = backNode;
            frontNode.next = curr;
            backNode.previous = curr;
            middleNode = curr;
            size++;
            return;
        }
        if (size % 2 == 0) {
            curr.previous = middleNode;
            curr.next = middleNode.next;
            middleNode.next.previous = curr;
            middleNode.next = curr;
            size++;
        } else {
            curr.previous = middleNode.previous;
            curr.next = middleNode;
            middleNode.previous.next = curr;
            middleNode.previous = curr;
            size++;
        }
        middleNode = curr;
    }

    public void pushBack(int val) {
        Node curr = new Node(val);
        curr.previous = backNode.previous;
        curr.next = backNode;
        backNode.previous.next = curr;
        backNode.previous = curr;
        size++;

        if (size == 1) {
            middleNode = curr;
        } else if (size % 2 != 0) {
            middleNode = middleNode.next;
        }
    }

    public int popFront() {
        if (size <= 0) {
            return -1;
        }
        int val = frontNode.next.val;
        frontNode.next.next.previous = frontNode;
        frontNode.next = frontNode.next.next;
        
        size--;

        if (size % 2 != 0) {
            middleNode = middleNode.next;
        }

        return val;
    }

    public int popMiddle() {
        if (size <= 0) {
            return -1;
        }
        int val = middleNode.val;
        middleNode.previous.next = middleNode.next;
        middleNode.next.previous = middleNode.previous;
        size--;

        if (size % 2 == 0) {
            middleNode = middleNode.previous;
        } else {
            middleNode = middleNode.next;
        }

        return val;
    }

    public int popBack() {
        if (size <= 0) {
            return -1;
        }
        int val = backNode.previous.val;
        backNode.previous = backNode.previous.previous;
        backNode.previous.next = backNode;
        size--;

        if (size % 2 == 0) {
            middleNode = middleNode.previous;
        }
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
