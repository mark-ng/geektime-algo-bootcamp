/**
 * 題目：买卖股票的最佳时机 II (Medium)
 */

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        // 0. Move index to 1-based
        prices.insert(prices.begin(), 0);

        // 1. Define f, initialize -OO
        vector<vector<int>> f(n + 1, vector<int>(2, -1e9));
        f[0][0] = 0;

        // 2. Loop over all states
        for (int i = 1; i <= n; i++) {
            // 3. Copy decisions
            f[i][1] = max(f[i][1], f[i - 1][0] - prices[i]);
            f[i][0] = max(f[i][0], f[i - 1][1] + prices[i]);
            for (int j = 0; j < 2; j++) {
                f[i][j] = max(f[i][j], f[i - 1][j]);
            }
        }

        // 4. return target
        return f[n][0];
    }
};

// 0: 0 -1000000000
// 7: 0 -7
// 1: 0 -1
// 5: 4 -1
// 3: 4 1
// 6: 7 1
// 4: 7 3
