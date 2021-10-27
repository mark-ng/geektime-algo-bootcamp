/**
 * 題目： N 皇后 (Hard)
 */
class Solution {
    private int n;
    private boolean[] taken;
    private List<Integer> permu;
    private List<List<Integer>> ans;
    private HashSet<Integer> minusD;
    private HashSet<Integer> plusD;

    // \ r-c
    // / r+c (0 + 3 1 + 2 3 + 1)

    public List<List<String>> solveNQueens(int n) {
        // pure permuatation problem
        // the only concern is diagalo
        this.n = n;
        minusD = new HashSet<>();
        plusD = new HashSet<>();
        taken = new boolean[n];
        permu = new ArrayList<>();
        ans = new ArrayList<>();
        recur(0);
        // System.out.println(ans);
        return buildAns(ans);
    }

    // 1 - 0 = 1
    // 0 - 1 = -1

    public void recur(int idx) { // idx = row
        if (idx == n) {
            List<Integer> copy = new ArrayList<>(permu);
            ans.add(copy);
            return;
        }

        for(int i = 0; i < n; i++) { // col
            int rowMinusCol = idx - i;
            int rowPlusCol = idx + i;
            if(!taken[i] && !minusD.contains(rowMinusCol) && !plusD.contains(rowPlusCol)) {
                taken[i] = true;
                permu.add(i);
                minusD.add(rowMinusCol);
                plusD.add(rowPlusCol);
                recur(idx + 1);
                taken[i] = false;
                permu.remove(permu.size() - 1);
                minusD.remove(rowMinusCol);
                plusD.remove(rowPlusCol);
            } 
        }    
    }

    public List<List<String>> buildAns(List<List<Integer>> arr) {
        List<List<String>> finalAns = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            List<String> tempAns = new ArrayList<>();
            for(int j = 0; j < arr.get(i).size(); j++) {
                String tempRow = "";
                for(int k = 0; k < n; k++) {
                    if(arr.get(i).get(j) == k) {
                        tempRow += "Q";
                    } else {
                        tempRow += ".";
                    }
                }
                tempAns.add(tempRow);
            }
            finalAns.add(tempAns);
        }
        return finalAns;
    }
}