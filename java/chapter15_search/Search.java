package chapter15_search;

public class Search {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 5, 9, 10, 40};
        System.out.println(binarySearch(array, array.length, 2));
        System.out.println(recursiveBinarySearch(array, array.length, 2));
    }

    public static int binarySearch(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] array, int n, int value) {
        return recursiveBinarySearchInternal(array, 0, n - 1, value);
    }

    private static int recursiveBinarySearchInternal(int[] array, int lo, int hi, int value) {
        if (lo > hi) {
            return - 1;
        }
        int mid = (hi + lo) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return recursiveBinarySearchInternal(array, lo, mid - 1, value);
        } else {
            return recursiveBinarySearchInternal(array, mid + 1, hi, value);
        }
    }
}
