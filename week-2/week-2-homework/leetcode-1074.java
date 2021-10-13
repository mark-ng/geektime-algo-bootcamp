/**
 * 題目：元素和为目标值的子矩阵数量 (Hard)
 */
import java.util.HashMap;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for(int a = i; a < m; a++) {
                for(int b = 0; b < n; b++) {
                    sum[b] += matrix[a][b];
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int[] prefixSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        for(int i = 0; i < prefixSum.length; i++) {
            int offset = prefixSum[i] - k;
            if(map.containsKey(offset)) {
                int count = map.get(offset);
                ans += count;
            }
            if(map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], map.get(prefixSum[i]) + 1);
            } else {
                map.put(prefixSum[i], 1);
            }
        }
        return ans;
    }
}