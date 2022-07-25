package leetcode.p1631_path_with_minimum_effort;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        System.out.println(solution.minimumEffortPath(heights)); // 2

        heights = new int[][]{
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };
        System.out.println(solution.minimumEffortPath(heights)); // 1

        heights = new int[][]{
                {1, 2, 1, 1, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1},
                {1, 1, 1, 2, 1}
        };
        System.out.println(solution.minimumEffortPath(heights)); // 0
    }

    private static class State {
        int x;
        int y;
        int effortFromStart;

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 从 (0, 0) 到 (i, j) 的最小体力消耗为 effortTo[i][j]
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }

        // base case
        effortTo[0][0] = 0;

        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.effortFromStart));
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curEffortFromStart = cur.effortFromStart;

            if (curX == m - 1 && curY == n - 1) {
                // 到终点
                return curEffortFromStart;
            }

            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }

            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNext = Math.max(effortTo[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                if (effortToNext < effortTo[nextX][nextY]) {
                    effortTo[nextX][nextY] = effortToNext;
                    pq.offer(new State(nextX, nextY, effortToNext));
                }
            }
        }
        
        return -1;
    }

    private List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 上下左右
        int[][] dirs = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }
}
