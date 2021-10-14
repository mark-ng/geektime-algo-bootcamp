/**
 * 題目：数组的度 (Easy)
 */

import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int minDis = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> firstPosMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            firstPosMap.putIfAbsent(nums[i], i);
            if(count > max) {
                max = count;
                minDis = i - firstPosMap.get(nums[i]) + 1;
            } else if (count == max) {
                minDis = Math.min(minDis, i - firstPosMap.get(nums[i]) + 1);
            }
            
        }
        return minDis;
    }
}