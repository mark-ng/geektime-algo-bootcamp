/**
 * 題目： 子集 (Medium)
 */
class Solution {

    public int n;
    public List<Integer> tempArr; 
    public List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        // 0 1 2
        n = nums.length;
        tempArr = new ArrayList<>();
        ans = new ArrayList<>();
        backtrack(0, nums);
        return ans;
    }

    public void backtrack(int idx, int[] nums) {
        if (idx == n) {
            ans.add((new ArrayList<>(tempArr)));
            return;
        }
        backtrack(idx + 1, nums);
        tempArr.add(nums[idx]);
        backtrack(idx + 1, nums);
        tempArr.remove(tempArr.size() - 1);
    }
}