/**
 * 題目：全排列 II (Medium)
 */
class Solution {
    public boolean[] taken;
    public List<Integer> permu;
    public List<List<Integer>> ans;
    public int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        taken = new boolean[n];
        permu = new ArrayList<>();
        ans = new ArrayList<>();
        int[] numsCopy = nums.clone();
        Arrays.sort(numsCopy);
        recur(numsCopy, 0);
        return ans;
    }

    public void recur(int[] nums, int idx) {
        if(idx == n) {
            List<Integer> copy = new ArrayList<>(permu);
            ans.add(copy);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(taken[i] || (i > 0 && nums[i] == nums[i - 1] && !taken[i - 1])) {
                continue;
            }
            taken[i] = true;
            permu.add(nums[i]);
            recur(nums, idx + 1);
            taken[i] = false;
            permu.remove(permu.size() - 1);
        }
    }
}