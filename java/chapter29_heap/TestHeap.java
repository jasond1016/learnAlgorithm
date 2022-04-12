package chapter29_heap;

import java.util.Arrays;

public class TestHeap {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] points = {{3,3},{5,-1}, {-2,4}};
//        int[][] points = {{1,3},{-2,2}};
//        int[][] points = {{6, 10}, {-3, 3}, {-2, 5}, {0, 2}};
        int[][] points = {{68, 97}, {34, -84}, {60, 100}, {2, 31}, {-27, -38}, {-73, -74}, {-55, -39}, {62, 91}, {62, 92}, {-57, -67}};
        int[][] closetPoints = solution.kClosest(points, 5);
        System.out.println(Arrays.deepToString(closetPoints));
    }
}
