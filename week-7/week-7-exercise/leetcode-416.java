/**
 * 題目：分割等和子集 (Medium)
 */

class Solution {
    public boolean canPartition(int[] nums) {
        // f[i][j] 前i個數選出一些數，總和是j, 是否可行
        int n = nums.length;
        int[] nums2 = new int[n + 1];
        for (int i = 0; i < n; i++) nums2[i + 1] = nums[i];
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += nums2[i];
        if (sum % 2 == 1) return false;

        boolean[] f = new boolean[sum / 2 + 1];
        f[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= nums2[i]; j--) {
                f[j] |= f[j - nums2[i]];
            }
        }

        return f[sum / 2];
    }
}