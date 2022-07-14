package leetcode.p0886_possible_bipartition;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] dislikes = new int[][]{
                {1,2},
                {1,3},
                {2,4},
        };
        System.out.println(solution.possibleBipartition(n, dislikes));

        n = 3;
        dislikes = new int[][]{
                {1,2},
                {1,3},
                {2,3},
        };
        System.out.println(solution.possibleBipartition(n, dislikes));

        n = 5;
        dislikes = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {1,5},
        };
        System.out.println(solution.possibleBipartition(n, dislikes));
        
    }

    boolean[] visited;
    boolean[] colors;
    boolean res;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 建图
        List<Integer>[] graph = buildGraph(n, dislikes);

        // 之后和 785 一样
        int count = graph.length;
        visited = new boolean[count];
        colors = new boolean[count];
        res = true;
        
        for (int i = 1; i < count; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return res;
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] arr : dislikes) {
            int x = arr[0];
            int y = arr[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        
        return graph;
    }
    
    private void traverse(List<Integer>[] graph, int n) {
        if (!res) {
            return;
        }

        for (int x : graph[n]) {
            if (!visited[x]) {
                colors[x] = !colors[n];
                visited[x] = true;
                traverse(graph, x);
            } else {
                if (colors[x] == colors[n]) {
                    res = false;
                }
            }
        }
    }
}
