/**
 * 題目： 在排序数组中查找元素的第一个和最后一个位置 (Medium)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        // find the smallest >= target
        int left = 0;
        int right = nums.length; // Possibly cannot find any
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) { // Just Copy
                right = mid; // smallest, take the left part
            } else {
                left = mid + 1;
            }
        }

        ans[0] = right;
        
        // find the largest <= target
        left = -1;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2; // Round up
            if (nums[mid] <= target) {
                left = mid; // largest, take the right part
            } else {
                right = mid - 1;
            }
        }

        ans[1] = right;

        if (ans[0] > ans[1]) {
            return new int[] {-1, -1};
        } 

        return ans;
    }
}