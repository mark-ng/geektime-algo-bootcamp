/**
 * 題目：最大子序和 (Easy)
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int[] prefixMin = new int[n + 1];
        int maxSum = -10001;
        for(int i = 1; i < n + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for(int i = 1; i < n + 1; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - prefixMin[i - 1]);
            prefixMin[i] = Math.min(prefixMin[i - 1], prefixSum[i]);
        }
        return maxSum;
    }
}