/**
 * 題目： 最长递增子序列 (Medium)
 */

// 暴力 (2^n)
class Solution {
    int[] nums;

    // ** chosen 狀態 **
    List<Integer> chosen;
    int max;

    public int lengthOfLIS(int[] nums) {
       this.nums = nums;
       chosen = new ArrayList<>();
       max = 0;
       dfs(0);
       return max;
    }

    // ** i 狀態 **
    private void dfs(int i) {
        // Base Case
        if (i == nums.length) {
            max = Math.max(max, chosen.size());
            return;
        }
        dfs(i + 1);
        if (chosen.isEmpty() || nums[i] > chosen.get(chosen.size() - 1)) {
            chosen.add(nums[i]);
            dfs(i + 1);
            chosen.remove(chosen.size() - 1);
        }
    }
}

// DP
// f[i] =        max        {f[j] + 1} 
//        j<i, a[j] < a[i]
class Solution {
    public int lengthOfLIS(int[] nums) {
      // n^2
      int[] f = new int[nums.length];
      f[0] = 1;
      for (int i = 1; i < nums.length; i++) {
          int max = 0;
          for (int j = 0; j <= i; j++) {
              if (nums[i] > nums[j]) {
                  max = Math.max(f[j], max);
              }
          }
          f[i] = max + 1;
      }
      int ans = f[0];
      for (int i = 1; i < f.length; i++) {
          ans = Math.max(ans, f[i]);
      }
      return ans;
    }
}