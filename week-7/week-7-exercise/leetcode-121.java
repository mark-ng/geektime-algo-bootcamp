/**
 * 題目：买卖股票的最佳时机 (Easy)
 */

// prefix min (0(n))
class Solution {
    public int maxProfit(int[] prices) {
        int[] prefixMin = new int[prices.length];
        prefixMin[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], prices[i]);
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prefixMin[i - 1];
            ans = Math.max(ans, diff);
        }
        return ans;
    }
}