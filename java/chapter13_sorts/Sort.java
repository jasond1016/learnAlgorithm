package chapter13_sorts;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println("before: " + arrayToString(array));
        countingSort(array, array.length);
        System.out.println("counting sort : " + arrayToString(array));
    }

    public static void countingSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }

        int max = array[0];
        for (int i = 0; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int[] bucket = new int[max + 1];

        for (int i = 0; i < n; i++) {
            bucket[array[i]] += 1;
        }
//        System.out.println(arrayToString(bucket));

        for (int i = 0; i < bucket.length - 1; i++) {
            bucket[i + 1] = bucket[i] + bucket[i + 1];
        }
//        System.out.println(arrayToString(bucket));

        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            temp[bucket[array[i]] - 1] = array[i];
            bucket[array[i]] = bucket[array[i]] - 1;
        }
//        System.out.println(arrayToString(temp));

        for (int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
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
