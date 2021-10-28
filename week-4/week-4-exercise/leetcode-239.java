/**
 * 題目： 滑动窗口最大值 (Hard)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int count = 0;
        q = new PriorityQueue<MyPair>(new PairComparator());
        for(int i = 0; i < nums.length; i++) {
            q.add(new MyPair(nums[i], i));
            if(i >= k - 1) {
                // 懶惰刪除
                 while(q.peek().idx <= i - k) {
                    q.poll();
                }
                ans[count] = q.peek().val;
                count++;
            } 
        }
        return ans;
    }

    private PriorityQueue<MyPair> q;
}

class MyPair {

    int val;
    int idx;

    public MyPair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class PairComparator implements Comparator<MyPair> {

    @Override
    // Min Heap
    public int compare(MyPair o1, MyPair o2) {
        return o1.val < o2.val ? 1 : -1;
    }
}
