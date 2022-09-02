package leetcode.p0773_sliding_puzzle;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = new int[][]{
                {1, 2, 3},
                {4, 0, 5},
        };
        System.out.println(solution.slidingPuzzle(board)); // 1

        board = new int[][]{
                {1, 2, 3},
                {5, 4, 0},
        };
        System.out.println(solution.slidingPuzzle(board)); // -1

        board = new int[][]{
                {4, 1, 2},
                {5, 0, 3},
        };
        System.out.println(solution.slidingPuzzle(board)); // 5
    }

    public int slidingPuzzle(int[][] board) {
        int[][] neighbour = convert(board);
        Set<String> visited = new HashSet<>();
        // 目标状态
        String target = "123450";

        // 起始状态
        StringBuilder sb = new StringBuilder();
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(ints[j]);
            }
        }
        String start = sb.toString();

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    // 通关
                    return step;
                }

                // 找到 '0' 的索引
                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) {

                }

                for (int adj : neighbour[idx]) {
                    if (adj == -1) {
                        continue;
                    }
                    // 0 和 周围换位置
                    String newBoard = swap(cur.toCharArray(), idx, adj);
                    // 不走回头路
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 交换位置
    private String swap(char[] toCharArray, int idx, int adj) {
        char temp = toCharArray[idx];
        toCharArray[idx] = toCharArray[adj];
        toCharArray[adj] = temp;
        return new String(toCharArray);
    }

    // 讲二维数组转换为一维数组索引和相邻元素索引
    // 例：array[i] = [x,y,z] 表示 i 周围元素的索引分别是 x,y,z
    private int[][] convert(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int total = rows * cols;
        int[][] res = new int[total][cols];
        for (int[] r : res) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                int x = 0;

                int left = index - 1;
                if (left >= 0 && left < total && left / cols == index / cols) {
                    res[index][x++] = left;
                }

                int right = index + 1;

                if (right >= 0 && right < total && right / cols == index / cols) {
                    res[index][x++] = right;
                }

                int up = index - cols;
                if (up >= 0 && up < total) {
                    res[index][x++] = up;
                }

                int down = index + cols;
                if (down >= 0 && down < total) {
                    res[index][x++] = down;
                }
            }
        }
        return res;
    }
}
