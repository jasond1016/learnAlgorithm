package chapter11;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 4, 1, 2, 6};
        System.out.println("before: " + arrayToString(array));
        bubbleSort(array, array.length);
        System.out.println("after : " + arrayToString(array));
    }

    public static void bubbleSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }

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
