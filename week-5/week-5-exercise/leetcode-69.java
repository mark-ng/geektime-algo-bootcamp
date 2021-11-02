/**
 * 題目： Sqrt(x) (Easy)
 */
class Solution {
    public int mySqrt(int x) {
        // return ans, where ans * ans <= x
        // 1 2 3 4
        // 1 1 0 0
        // find the largest ans, where ans * ans <= x
        int left = 1;
        int right = x; // Must be found
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // Round up left + (right - left + 1) / 2
            if (mid <= x / mid) {
               left = mid; // largest, take the right part
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}