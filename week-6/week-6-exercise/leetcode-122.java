/**
 * 題目： 不同路径 II (Medium)
 */

// 暴力 (2^n)
class Solution {

    int[] prices;
    int maxProfit;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.maxProfit = 0;
        dfs(0, 0, maxProfit);
        return maxProfit;
    }

    private void dfs(int pos, int status, int profit) {
        if (pos == prices.length) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }

        // No Operation
        dfs(pos + 1, status, profit);

        // 0 表示不持有股票，1表示持有股票
        // Operation 
        if (status == 0) {
            // if previous status is 0, turn to 1
            // 0 -> 1, mean buy
            dfs(pos + 1, 1, profit - prices[pos]);
        } else {
            // if previous status is 1, turn to 0
            // 1 -> 0, mean sell
            dfs(pos + 1, 0, profit + prices[pos]);
        }

    }
}

// Greedy 
class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

}