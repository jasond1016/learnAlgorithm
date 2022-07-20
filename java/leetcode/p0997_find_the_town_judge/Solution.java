package leetcode.p0997_find_the_town_judge;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        int[][] trust = new int[][]{
                {1, 2}
        };
        System.out.println(solution.findJudge(n, trust));

        n = 3;
        trust = new int[][]{
                {1, 3},
                {2, 3}
        };
        System.out.println(solution.findJudge(n, trust));

        n = 3;
        trust = new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}
        };
        System.out.println(solution.findJudge(n, trust));
    }

    // graph[i][j] == 1 时表示 i trust j
    int[][] graph;

    public int findJudge(int n, int[][] trust) {
        // 建图
        graph = buildGraph(n, trust);

        // 先假设第一个候选人是法官
        int candidate = 0;
        for (int other = 1; other < n; other++) {
            if (trusts(candidate, other) || !trusts(other, candidate)) {
                // candidate肯定不是法官，排除掉
                candidate = other;
            } else {
                // candidate继续充当法官
            }
        }

        // 验证最后得到的candidate是不是法官
        for (int other = 0; other < n; other++) {
            if (other == candidate) {
                continue;
            }

            if (!trusts(other, candidate) || trusts(candidate, other)) {
                // 只有所有人都新人法官，并且法官不信任所有人时，才证明是法官
                return -1;
            }
        }
        return candidate + 1;
    }

    private int[][] buildGraph(int n, int[][] trust) {
        int[][] graph = new int[n][n];
        for (int[] arr : trust) {
            int a = arr[0];
            int b = arr[1];
            graph[a-1][b-1] = 1;
        }
        return graph;
    }

    private boolean trusts(int i, int j) {
        return graph[i][j] == 1;
    }
}
