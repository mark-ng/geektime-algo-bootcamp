/**
 * 題目： 不同路径 II (Medium)
 */

// 暴力
class Solution {
    int m;
    int n;
    int[][] obstacleGrid;
    int ans = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dfs(x + 1, y)
        // dfs(x, y + 1)
        this.obstacleGrid = obstacleGrid;
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        this.ans = 0;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (obstacleGrid[x][y] == 1) return;

        // Base case
        if (x == m - 1 && y == n - 1) {
            ans++;
            return;
        }

        dfs(x + 1, y);
        dfs(x, y + 1);
    }
}

// Recursive DP
class Solution {

    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        HashMap<String, Integer> map = new HashMap<>();
        return uniquePaths(0, 0, map);
    }

    private int uniquePaths(int x, int y, HashMap<String, Integer> memo) {
        if (x < 0 || x >= obstacleGrid.length || y < 0 || y >= obstacleGrid[0].length) return 0;
        if (obstacleGrid[x][y] == 1) return 0;
        String hashKey = x + "," + y;
        if (memo.containsKey(hashKey)) {
            return memo.get(hashKey);
        }
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1;
        }
        memo.put(hashKey, uniquePaths(x + 1, y, memo) + uniquePaths(x, y + 1, memo));
        return memo.get(hashKey);
    }

}

// Tabula DP
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
    int[][] f = new int[m][n];
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (obstacleGrid[i][j] == 1) f[i][j] = 0;
              else if (i == 0 && j == 0) f[i][j] = 1;
              else if (i == 0) f[i][j] = f[i][j - 1];
              else if (j == 0) f[i][j] = f[i - 1][j];
              else f[i][j] = f[i - 1][j] + f[i][j - 1];
          }
      } 
      return f[m - 1][n - 1];
    }
}