package chapter12_sorts;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 2, 3, 4};
        System.out.println("before: " + arrayToString(array));
        mergeSort(array, array.length);
        System.out.println("merge sort : " + arrayToString(array));
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
