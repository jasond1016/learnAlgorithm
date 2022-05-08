package leetcode.p0622_design_circular_queue;

public class Solution {
    public static void main(String[] args) {
        int k = 3;
        MyCircularQueue obj = new MyCircularQueue(k);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());
    }

}

class MyCircularQueue {
    private int[] a;
    private int start;
    private int end;
    private int size;
    public MyCircularQueue(int k) {
        a = new int[k];
    }

    public boolean enQueue(int value) {
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

    public boolean deQueue() {
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

    public int Front() {
        return isEmpty() ? -1 : a[start];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (end == 0) {
            return a[a.length - 1];
        } else {
            return a[end - 1];
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == a.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */