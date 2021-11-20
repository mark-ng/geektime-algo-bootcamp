/**
 * 題目：打家劫舍 (Medium)
 */

// DP
class Solution {
    public int rob(int[] nums) {
        // f[i][0] = max(f[i - 1][0], f[i - 1][1])
        // f[i][1] = f[i - 1][0] + nums[i]
        int[] nums2 = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nums2[i + 1] = nums[i];
        }
        int[][] dp = new int[nums2.length][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = -1000000000;
            dp[i][1] = -1000000000;
        }
        dp[0][0] = 0;
        for (int i = 1; i < nums2.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums2[i];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}