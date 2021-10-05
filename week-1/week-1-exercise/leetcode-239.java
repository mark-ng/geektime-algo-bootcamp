class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // create a deque (maining a monotonic decreasing order)
        // for 每一個item
            // 先看最頭有沒有越界 <= i - k, 有的話pollFirst()
            // while queue is not empty, if the head of queue is smaller than new element
            // , pollLast(), until is is a monotonic decreasing queue
            // if i > k - 1, 開始加答案(queue的first)
        // idx 1 2
        // val 3 -1
        Deque<Integer> queue = new ArrayDeque<>();
        int ansIdx = 0;
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            while(!queue.isEmpty() && queue.getFirst() <= i - k) {
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if(i >= k - 1) {
                ans[ansIdx] = nums[queue.getFirst()];
                ansIdx++;
            }
        }
        return ans;
    }
}