package chapter28_heap;

public class TestHeap {
    public static void main(String[] args) {
        Heap heap = new Heap(14);
        heap.insert(33);
        heap.insert(27);
        heap.insert(21);
        heap.insert(16);
        heap.insert(13);
        heap.insert(15);
        heap.insert(19);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(12);

        System.out.println(heap);
        heap.removeMax();
        System.out.println(heap);

        heap.insert(22);
        System.out.println(heap);
        heap.insert(3);
        System.out.println(heap);
    }
}
