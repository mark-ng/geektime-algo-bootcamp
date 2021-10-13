/**
 * 題目：和为k的子数组
 */

import java.util.HashMap;

class Solution {
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