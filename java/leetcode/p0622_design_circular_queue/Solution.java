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
    private int end = -1;
    private int size;
    public MyCircularQueue(int k) {
        a = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        end = (end + 1) % a.length;
        a[end] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start = (start + 1) % a.length;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : a[start];
    }

    public int Rear() {
        return isEmpty() ? -1 : a[end];
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