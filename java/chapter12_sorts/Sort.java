package chapter12_sorts;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 2, 3, 4};
        System.out.println("before: " + arrayToString(array));
//        mergeSort(array, array.length);
//        System.out.println("merge sort : " + arrayToString(array));
        quickSort(array, array.length);
        System.out.println("quick sort : " + arrayToString(array));
    }

    public static void mergeSort(int[] a, int n) {
        mergeSortC(a, 0, n - 1);
    }

    public static void mergeSortC(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        mergeSortC(array, start, middle);
        mergeSortC(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    public static void merge(int[] sourceArray, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (sourceArray[i] < sourceArray[j]) {
                temp[k++] = sourceArray[i++];
            } else {
                temp[k++] = sourceArray[j++];
            }
        }
        
        int start = i;
        int end = q;
        if (i > q) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = sourceArray[start++];
        }

        for (i = 0; i <= r - p; i++) {
            sourceArray[p + i] = temp[i];
        }

    }

    public static void quickSort(int[] array, int n) {
        quickSortC(array, 0, n - 1);
    }

    private static void quickSortC(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        //获取分区点
        int q = partition(array, p, r);
        quickSortC(array, p, q - 1);
        quickSortC(array, q, r);
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, r);
        return i;
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
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
