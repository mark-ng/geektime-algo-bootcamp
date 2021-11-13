/**
 * 題目： 三角形最小路径和 (Medium)
 */

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
