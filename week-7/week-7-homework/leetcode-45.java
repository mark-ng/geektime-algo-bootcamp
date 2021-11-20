/**
 * 題目：跳跃游戏 II (Medium)
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // f[i] = min { f[j] } + 1 where j < i & i - j <= nums[j]
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i - j <= nums[j]) {
                    f[i] = Math.min(curMin, f[j] + 1);
                    curMin = f[i];
                }
            }
        }
        return f[n - 1];
    }
}