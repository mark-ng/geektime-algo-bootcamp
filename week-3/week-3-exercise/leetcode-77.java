/**
 * 題目： 组合 (Medium)
 */
class Solution {

    public int n;
    public int k;
    public List<Integer> tempArr; 
    public List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        tempArr = new ArrayList<>();
        ans = new ArrayList<>();
        backtrack(1);
        return ans;
    }

    public void backtrack(int idx) {
        if(tempArr.size() > k ||(tempArr.size() + (n - idx + 1)) < k) return;
        if (idx == n + 1) {
            ans.add((new ArrayList<>(tempArr)));
            return;
        }
        backtrack(idx + 1);
        tempArr.add(idx);
        backtrack(idx + 1);
        tempArr.remove(tempArr.size() - 1);
    }
}