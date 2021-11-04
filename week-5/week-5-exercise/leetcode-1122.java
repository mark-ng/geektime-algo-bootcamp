/**
 * 題目： 数组的相对排序 (Easy)
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // create an array of length 1001
        // update the count for each pos
        // for arr2 and put to ans
        // loop the 1001 array again to check there are value not count yet
        int[] map = new int[1001];
    
        for(int n1: arr1) {
            map[n1]++;
        }
        // System.out.println(Arrays.toString(map));
        int[] ans = new int[arr1.length];
        int count = 0;
        for(int n2: arr2) {
            while (map[n2] > 0) {
                ans[count] = n2;
                map[n2]--;
                count++;
            }
        }
        for(int i = 0; i < 1001; i++) {
            while (map[i] > 0) {
                ans[count] = i;
                map[i]--;
                count++;
            }
        }
        return ans;
    }
}