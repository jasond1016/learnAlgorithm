package leetcode.p0323_number_of_connected_components_in_a_undirected_graph;

public class Solution {
    private static class UF {
        // parents[x]是x的父节点
        int[] parents;
        // 连通分量
        int count;
        // size[x]是x的节点数
        int[] size;

        public UF(int n) {
            parents = new int[n];
            count = n;
            size = new int[n];
            for (int i = 0; i < n; i++) {
                // 初始状态下，每个节点的父节点都是自己，节点数都是1
                parents[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            // p节点的根节点
            int rootOfP = find(p);
            // q节点的根节点
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) {
                // 相同说明已连通
                return;
            }

            // 为了尽量平衡数，把小树接到大树下面
            if (size[rootOfP] > size[rootOfQ]) {
                parents[rootOfQ] = rootOfP;
                size[rootOfP] += size[rootOfQ];
            } else {
                parents[rootOfP] = rootOfQ;
                size[rootOfQ] += size[rootOfP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            return rootOfP == rootOfQ;
        }
        
        public int count() {
            return count;
        }
        
        private int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }
            return x;
        }
    }

    int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] arr : edges) {
            uf.union(arr[0], arr[1]);
        }
        return uf.count();
    }
}
