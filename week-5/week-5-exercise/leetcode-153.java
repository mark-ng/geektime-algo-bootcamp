/**
 * 題目： 寻找旋转排序数组中的最小值 (Medium)
 */
class Solution {
    public int findMin(int[] nums) {
        // 3 4 5 1 2
        // 0 0 0 1 1
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }
}