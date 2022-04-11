package chapter28_heap;

public class Heap {
    // 数组，从下标1开始存储数据
    private int[] a;
    // 堆中已经存储的数据
    private int count;
    // 堆容量
    private int capacity;

    public Heap(int capacity) {
        this.a = new int[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
    }

    public void insert(int value) {
        if (count >= capacity) {
            // 堆已满
            return;
        }

        a[++count] = value;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }

        a[1] = a[count--];
        heapify(this.a, this.count, 1);
    }

    private static void buildHeap(int[] a, int count) {
        for (int i = count / 2; i >= 1; i--) {
            heapify(a, count, i);
        }
    }

    public static void sort(int[] a, int count) {
        buildHeap(a, count);
        while (count > 1) {
            swap(a, 1, count);
            count--;
            heapify(a, count, 1);
        }
    }

    private static void heapify(int[] a, int count, int i) {
        while (true) {
            if (i * 2 <= count && a[i] < a[i * 2]) {
                swap(a, i, i * 2);
                i = i * 2;
            } else if (i * 2 + 1 <= count && a[i] < a[i * 2 + 1]) {
                swap(a, i, i * 2 + 1);
                i = i * 2 + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count + 1; i++) {
            sb.append(a[i]).append(" ");
        }
        return sb.toString();
    }
}
