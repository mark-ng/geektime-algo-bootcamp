/**
 * 題目： 岛屿数量 (Medium)
 */

class Solution {
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m * n];
        for (int i = 0; i < m * n; i++) fa[i] = i;
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {   
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                    if (grid[ni][nj] == '1') {
                        unionSet(num(i, j), num(ni, nj));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && fa[num(i, j)] == num(i, j)) ans++;
            }
        }

        return ans;
    }

    public int num(int i, int j) {
        return i * n + j;
    }

    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    public void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    int[] fa;
    int m;
    int n;
}