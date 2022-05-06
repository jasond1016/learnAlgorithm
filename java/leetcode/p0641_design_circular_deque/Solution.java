package leetcode.p0641_design_circular_deque;

public class Solution {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        System.out.println(obj.insertLast(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getRear());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getFront());

        obj = new MyCircularDeque(77);
        System.out.println(obj.insertFront(89));
        System.out.println(obj.getRear());
        System.out.println(obj.deleteLast());
        System.out.println(obj.getRear());
        System.out.println(obj.insertFront(19));
        System.out.println(obj.insertFront(23));
        System.out.println(obj.insertFront(23));
        System.out.println(obj.insertFront(82));
        System.out.println(obj.isFull());
        System.out.println(obj.insertFront(45));
        System.out.println(obj.isFull());
        System.out.println(obj.getRear());
        System.out.println(obj.deleteLast());
        System.out.println(obj.getFront());
        System.out.println(obj.getFront());
        System.out.println(obj.insertLast(74));
        System.out.println(obj.deleteFront());
        System.out.println(obj.getFront());
        System.out.println(obj.insertLast(98));
        
    }
}

class MyCircularDeque {
//    Implement the MyCircularDeque class:
//
//    MyCircularDeque(int k) Initializes the deque with a maximum size of k.
//    boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
//    boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
//    boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
//    boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
//    int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
//    int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
//    boolean isEmpty() Returns true if the deque is empty, or false otherwise.
//    boolean isFull() Returns true if the deque is full, or false otherwise.

    private int[] a;
    private int size;
    private int start;
    private int end;

    public MyCircularDeque(int k) {
        this.a = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (start == 0) {
            start = a.length - 1;
        } else {
            start--;
        }
        a[start] = value;
        size++;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (end == a.length - 1) {
            a[end] = value;
            end = 0;
        } else {
            a[end++] = value;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (start == a.length - 1) {
            start = 0;
        } else {
            start++;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (end == 0) {
            end = a.length - 1;
        } else {
            end--;
        }
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : a[start];
    }

    public int getRear() {
        int lastIndex = 0;
        if (end == 0) {
            lastIndex = a.length - 1;
        } else {
            lastIndex = end - 1;
        }
        return isEmpty() ? -1 : a[lastIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return a.length == this.size;
    }
}
