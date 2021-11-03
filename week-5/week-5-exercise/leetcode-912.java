/**
 * 題目： 排序数组
 */

/**
 * Heap Sort
 */
class Solution {
    public int[] sortArray(int[] nums) {
        int[] ans = new int[nums.length];
        // Heap sort
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num: nums) {
            q.offer(num);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int n = q.poll();
            ans[count] = n;
            count++;
        }
        return ans;
    }
}