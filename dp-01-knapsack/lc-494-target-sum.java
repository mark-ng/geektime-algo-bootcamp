// Recursive Solution

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.ans = 0;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int idx, int curSum) {
        if (idx == nums.length) {
            if (curSum == target) {
                this.ans++;
            }
            return;
        }
        // -
        dfs(idx + 1, curSum - nums[idx]);
        // +
        dfs(idx + 1, curSum + nums[idx]);
    }

    int[] nums;
    int target;
    int ans;
}