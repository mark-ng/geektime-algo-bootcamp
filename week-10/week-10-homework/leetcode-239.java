/**
 * 題目： 滑动窗口最大值 (Hard)
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            if (tree.containsKey(nums[i])) {
                tree.put(nums[i], tree.get(nums[i]) + 1);
            } else {
                tree.put(nums[i], 1);
            }
        }
        ans[0] = tree.lastKey();
        for (int i = k; i < nums.length; i++) {
            if (tree.containsKey(nums[i])) {
                tree.put(nums[i], tree.get(nums[i]) + 1);
            } else {
                tree.put(nums[i], 1);
            }
            int oldCount = tree.get(nums[i - k]);
            if (oldCount == 1) {
                tree.remove(nums[i - k]);
            } else {
                tree.put(nums[i - k], oldCount - 1);
            }
            ans[i - k + 1] = tree.lastKey();
        }
        return ans;
    }
}
