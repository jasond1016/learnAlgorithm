package chapter42_dynamic_programming;

public class EditDistance {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int m = a.length;
    private int n = b.length;
    private int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        editDistance.lwstBT(0, 0, 0);
        System.out.println(editDistance.minDistance);

        System.out.println(editDistance.lwstDP());

        System.out.println(editDistance.lcs());
    }

    public void lwstBT(int i, int j, int editDistance) {
        if (i == n || j == m) {
            if (i < n) {
                editDistance += n - i;
            }
            if (j < m) {
                editDistance += m - j;
            }
            if (editDistance < minDistance) {
                minDistance = editDistance;
            }
            return;
        }

        if (a[i] == b[j]) {
            lwstBT(i + 1, j + 1, editDistance);
        } else {
            // 删除a[i]或者b[j]前添加一个字符
            lwstBT(i + 1, j, editDistance + 1);
            // 删除b[j]或者a[i]前添加一个字符
            lwstBT(i, j + 1, editDistance + 1);
            // 将a[i]和b[j]替换为相同字符
            lwstBT(i + 1, j + 1, editDistance + 1);
        }
    }

    public int lwstDP() {
        int[][] minDist = new int[n][m];
        // 初始化第0行:a[0..0]与b[0..j]的编辑距离
        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                minDist[0][j] = j;
            } else if (j != 0) {
                minDist[0][j] = minDist[0][j - 1] + 1;
            } else {
                minDist[0][j] = 1;
            }
        }

        // 初始化第0列:a[0..i]与b[0..0]的编辑距离
        for (int i = 0; i < n; i++) {
            if (b[0] == a[i]) {
                minDist[i][0] = i;
            } else if (i != 0) {
                minDist[i][0] = minDist[i - 1][0] + 1;
            } else {
                minDist[i][0] = 1;
            }
        }

        // 按行填表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                } else {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
                }
            }
        }

        return minDist[n - 1][m - 1];
    }

    private int min(int x, int y, int z) {
        int minValue = Integer.MAX_VALUE;
        if (x < minValue) {
            minValue = x;
        }
        if (y < minValue) {
            minValue = y;
        }
        if (z < minValue) {
            minValue = z;
        }
        return minValue;
    }

    public int lcs() {
        int[][] maxLsc = new int[n][m];

        for (int j = 0; j < m; j++) {
            if (a[0] == b[j]) {
                maxLsc[0][j] = 1;
            } else if (j != 0) {
                maxLsc[0][j] = maxLsc[0][j - 1];
            } else {
                maxLsc[0][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (b[0] == a[i]) {
                maxLsc[i][0] = 1;
            } else if (i != 0) {
                maxLsc[i][0] = maxLsc[i - 1][0];
            } else {
                maxLsc[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    maxLsc[i][j] = max(maxLsc[i - 1][j - 1] + 1, maxLsc[i - 1][j], maxLsc[i][j - 1]);
                } else {
                    maxLsc[i][j] = max(maxLsc[i - 1][j - 1], maxLsc[i - 1][j], maxLsc[i][j - 1]);
                }
            }
        }

        return maxLsc[n - 1][m - 1];
    }

    private int max(int x, int y, int z) {
        int maxValue = Integer.MIN_VALUE;
        if (x > maxValue) {
            maxValue = x;
        }
        if (y > maxValue) {
            maxValue = y;
        }
        if (z > maxValue) {
            maxValue = z;
        }
        return maxValue;
    }
}
