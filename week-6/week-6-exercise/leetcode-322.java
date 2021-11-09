/**
 * 題目： 零钱兑换 (Medium)
 */

// opt(n) = min(opt(n - 1), opt(n - 9), opt(n - 10)) + 1

// 暴力 
// O(S^n)
class Solution {
    int[] coins;
    int minStep;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.minStep = Integer.MAX_VALUE;
        dfs(amount, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void dfs(int amount, int step) {
         // Base case
       if (amount < 0) {
           return;
       } else if (amount == 0) {
           minStep = Math.min(minStep, step);
           return;
       }

       for (int coin : coins) {
           dfs(amount - coin, step + 1);
       }
    }
}
// DP
// O(Sn)，其中 S 是金额， n是面额数
class Solution {

    public int coinChange(int[] coins, int amount) {
        int INF = amount + 1;
        int[] opt = new int[amount + 1];
        opt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            opt[i] = INF;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    opt[i] = Math.min(opt[i], opt[i - coin] + 1);
                }
            }
        }
        if (opt[amount] >= INF) opt[amount] = -1;
        return opt[amount];
    }

}