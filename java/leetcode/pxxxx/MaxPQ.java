package leetcode.pxxxx;

public class MaxPQ<E extends Comparable<E>> {
    private int capacity;
    private int size;
    private E[] pq;

    public MaxPQ(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        pq = (E[]) new Comparable[capacity + 1];
    }
    
    public E max() {
        return pq[1];
    }

    public void insert(E e) {
        if (size == capacity) {
            return;
        }
        size++;
        pq[size] = e;
        swim(size);
    }

    public E delMax() {
        if (size == 0) {
            return null; 
        }
        E max = pq[1];
        swap(1, size);
        pq[size] = null;
        sink(1);
        size--;
        return max;
    }
    
    private void sink(int x) {
        while (left(x) <= size) {
            int max = left(x);
            if (right(x) <= size && less(max, right(x))) {
                max = right(x);
            }
            if (less(max, x)) {
                break;
            }
            swap(x, max);
            x = max;
        }
    }
    
    private void swim(int x) {
        while (x > 1 && less(parent(x), x)) {
            swap(x, parent(x));
            x = parent(x);
        }
    }

    private boolean less(int x, int y) {
        return pq[x].compareTo(pq[y]) < 0;
    }
    
    private void swap(int x, int y) {
        E temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;
    }

    private int parent(int x) {
        return x / 2;
    }

    private int left(int x) {
        return x * 2;
    }

    private int right(int x) {
        return x * 2 + 1;
    }
}
