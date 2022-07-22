package leetcode.p0743_network_delay_time;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = new int[][]{
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int n = 4;
        int k = 2;
        System.out.println(solution.networkDelayTime(times, n, k)); // 2

        times = new int[][]{
                {1,2,1}
        };
        n = 2;
        k = 1;
        System.out.println(solution.networkDelayTime(times, n, k)); // 1

        times = new int[][]{
                {1,2,1}
        };
        n = 2;
        k = 2;
        System.out.println(solution.networkDelayTime(times, n, k)); // -1
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // 节点编号从1开始
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 建图 from -> [to, weight]
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }

        // 使用 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最长的那一条路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                // 存在不可达节点
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }

        return res;
    }

    private static class State {
        // 记录节点 id
        int id;
        // 记录距离起点的距离
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    private int[] dijkstra(int start, List<int[]>[] graph) {
        // distTo[i] 表示起点到i的最短距离
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case 起点到起点距离为0
        distTo[start] = 0;

        // 引入优先级队列提升效率：目前队列中距离最短的最有可能是最终最短的
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        // 从起点开始 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            int distFromStart = cur.distFromStart;
            // 如果大于最短距离直接舍弃掉
            if (distFromStart > distTo[curId]) {
                continue;
            }
            // 将相邻节点装入队列
            for (int[] neighbor : graph[curId]) {
                int nextId = neighbor[0];
                int distToNext = distTo[curId] + neighbor[1];
                if (distToNext < distTo[nextId]) {
                    // 到下一节点距离更短，更新 distTo，并装进队列
                    distTo[nextId] = distToNext;
                    pq.offer(new State(nextId, distToNext));
                }
            }
        }
        return distTo;
    }
}
