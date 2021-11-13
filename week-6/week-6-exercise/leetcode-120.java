/**
 * 題目： 三角形最小路径和 (Medium)
 */

// 暴力
class Solution {

    List<List<Integer>> triangle;
    int minPathSum;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.minPathSum = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        return minPathSum;
    }

    private void dfs(int level, int pos, int sum) {
        if (level == triangle.size()) {
            minPathSum = Math.min(minPathSum, sum);
            return;
        }
        int left = pos;
        int right = pos + 1;
        int value = triangle.get(level).get(pos);
        dfs(level + 1, left, sum + value);
        dfs(level + 1, right, sum + value);
    }
}

// Recursive (with memoization)
class Solution {

    List<List<Integer>> triangle;
    Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.memo = new Integer[triangle.size()][triangle.size()];
        return dfs(0, 0);
    }

    private int dfs(int level, int pos) {
        if (level == triangle.size()) {
            return 0;
        }
        if (memo[level][pos] != null) {
            return memo[level][pos];
        }
        int left = pos;
        int right = pos + 1;
        int value = triangle.get(level).get(pos);
        int leftMinPathSum = dfs(level + 1, left);
        int rightMinPathSum = dfs(level + 1, right);
        memo[level][pos] = Math.min(leftMinPathSum, rightMinPathSum) + value;
        return memo[level][pos];
    }
}

// Tabula dp
class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int level = n - 1; level >= 0; level--) {
            for (int j = 0; j <= level; j++) {
                dp[level][j] = Math.min(dp[level + 1][j], dp[level + 1][j + 1]) + triangle.get(level).get(j);
            }
        }
        return dp[0][0];
    }

}
