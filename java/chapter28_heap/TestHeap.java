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

        int[] unsortedArray = new int[]{0, 9, 6, 3, 1, -1};
        System.out.println(arrayToString(unsortedArray));
        Heap.sort(unsortedArray, unsortedArray.length - 1);
        System.out.println(arrayToString(unsortedArray));
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int element : array) {
            sb.append(element).append(", ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
}
