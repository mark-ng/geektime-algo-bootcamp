/**
 * 題目：跳跃游戏 (Medium)
 */

class Solution {
    public boolean canJump(int[] nums) {
        // one of j where j < i can reach me -> and f[j] = true -> true
        // f[i] = { f[j] } where i - j <= nums[j] & f[j] = true
        // dp[0] = true;
        int n = nums.length;
        boolean[] f = new boolean[n];
        for (int i = 0; i < n; i++) f[i] = false;
        f[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j <= nums[j] && f[j]) {
                    f[i] = true;
                }
            }
        }
        return f[n - 1];
    }
}