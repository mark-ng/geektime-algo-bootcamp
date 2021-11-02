/**
 * 題目： 分割数组的最大值 (Hard)
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int num: nums) {
            left = Math.max(left, num); // if size too small, cannot fit in 1 box
            right += num;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (validate(nums, m, mid)) {
                right = mid; // smallest, take the left part
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // if each box have size X, check if m box is enough
    public boolean validate(int[] nums, int m, int size) {
        int box = 0;
        int count = 1;
        for(int num: nums) {
            if (box + num <= size) {
                box += num;
            } else {
                count++;
                if (num > size) return false;
                box = num;
            }
        }
        return count <= m;
    }
}