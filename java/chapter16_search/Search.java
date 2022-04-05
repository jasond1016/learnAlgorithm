package chapter16_search;

public class Search {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        System.out.println(binarySearch(array, array.length, 8)); // 5
        System.out.println(binarySearch2(array, array.length, 8)); // 5
        System.out.println(binarySearch3(array, array.length, 8)); // 7
        System.out.println(binarySearch4(array, array.length, 8)); // 5
        System.out.println(binarySearch5(array, array.length, 9)); // 7
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
    }

    // 查找第一个值等于给定值的元素 方法1
    public static int binarySearch(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (value <= array[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo < n && array[lo] == value) {
            return lo;
        } else {
            return -1;
        }
    }

    // 查找第一个值等于给定值的元素 方法2
    public static int binarySearch2(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (value < array[mid]) {
                hi = mid - 1;
            } else if (value > array[mid]) {
                lo = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }

    // 查找最后一个值等于给定值的元素
    public static int binarySearch3(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (value < array[mid]) {
                hi = mid - 1;
            } else if (value > array[mid]) {
                lo = mid + 1;
            } else {
                if (mid == n - 1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }

    // 查找第一个大于等于给定值的元素
    public static int binarySearch4(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (value > array[mid]) {
                lo = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }

        }

        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    public static int binarySearch5(int[] array, int n, int value) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (value >= array[mid]) {
                if (mid == n - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    // leetcode 33. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < nums[high]) {
                    if (target < nums[mid] || target > nums[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (target > nums[mid] || target < nums[low]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
