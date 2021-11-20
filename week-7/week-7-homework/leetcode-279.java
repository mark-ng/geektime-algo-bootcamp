/**
 * 題目：完全平方数 (Medium)
 */

class Solution {
    public int numSquares(int n) {

        List<Integer> choices = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (perfectSquare(i)) {
                choices.add(i);
            }
        }
        
        int pS = choices.size();
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1000000000;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int choice: choices) {
                if (i - choice >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - choice] + 1);
                }
            }
        }

        return dp[n];
    }

    private boolean perfectSquare(int n) {
        for (int i = 0; i <= n; i++) {
            if (i * i == n) {
                return true;
            }
        }
        return false;
    }
}