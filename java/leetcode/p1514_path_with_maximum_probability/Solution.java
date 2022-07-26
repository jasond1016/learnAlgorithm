package leetcode.p1514_path_with_maximum_probability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };
        double[] succProb = new double[]{
                0.5, 0.5, 0.2
        };
        int start = 0;
        int end = 2;
        System.out.println(solution.maxProbability(n, edges, succProb, start, end)); // 0.25

        n = 3;
        edges = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };
        succProb = new double[]{
                0.5, 0.5, 0.3
        };
        start = 0;
        end = 2;
        System.out.println(solution.maxProbability(n, edges, succProb, start, end)); // 0.3

        n = 3;
        edges = new int[][]{
                {0, 1}
        };
        succProb = new double[]{
                0.5
        };
        start = 0;
        end = 2;
        System.out.println(solution.maxProbability(n, edges, succProb, start, end)); // 0
    }

    private static class State {
        int id;
        double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 建图
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(new double[]{to, succProb[i]});
            graph[to].add(new double[]{from, succProb[i]});
        }

        return dijkstra(start, end, graph);
    }

    private double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] probTo = new double[graph.length];
        // 初始赋不可能的值
        Arrays.fill(probTo, -1);
        // base case
        probTo[start] = 1;

        // probFromStart 大的排在前面
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));

        // BFS
        pq.offer(new State(start, 1));
        
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            double curProbFromStart = cur.probFromStart;

            if (curId == end) {
                // 到达终点
                return curProbFromStart;
            }

            if (curProbFromStart < probTo[curId]) {
                // 已经有一条概率大的路线了
                continue;
            }

            // 将相邻节点装入队列
            for (double[] neighbors : graph[curId]) {
                int nextId = (int) neighbors[0];
                double probToNext = probTo[curId] * neighbors[1];
                if (probToNext > probTo[nextId]) {
                    probTo[nextId] = probToNext;
                    pq.offer(new State(nextId, probToNext));
                }
            }
        }

        return 0.0;
    }
}

