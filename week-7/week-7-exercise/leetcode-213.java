/**
 * 題目：打家劫舍 II (Medium)
 */

// 2 DP
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] nums2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums2[i + 1] = nums[i];
        }
        int[][] dp = new int[nums2.length][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1000000000;
            dp[i][1] = -1000000000;
        }
        // dont steal the first
        dp[1][0] = 0;
        for (int i = 2; i < nums2.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums2[i];
        }
        int ans = Math.max(dp[n][0], dp[n][1]);

        dp[1][0] = 0;
        dp[1][1] = nums2[1];

        for (int i = 2; i < nums2.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums2[i];
        }

        return Math.max(ans, dp[n][0]);

    }
}