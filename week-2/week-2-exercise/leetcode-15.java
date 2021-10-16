/**
 * 題目：最大子序和 (Easy)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> allPairs = twoSum(nums, i + 1, -nums[i]);
            for(List<Integer> pair: allPairs) {
                List<Integer> triples = new ArrayList<>();
                triples.add(pair.get(0));
                triples.add(pair.get(1));
                triples.add(nums[i]);
                ans.add(triples);
            }
        }
        
        return ans;
    }

    private List<List<Integer>> twoSum(int[] sortedNums, int start, int target) {
        int j = sortedNums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = start; i < sortedNums.length; i++) {
            if(i != start && sortedNums[i] == sortedNums[i - 1]) continue;
            while(i < j && sortedNums[i] + sortedNums[j] > target) j--;
            if(i < j && sortedNums[i] + sortedNums[j] == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(sortedNums[i]);
                temp.add(sortedNums[j]);
                ans.add(temp);
            }
        }
        return ans;
    }
}