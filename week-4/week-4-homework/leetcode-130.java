/**
 * 題目： 被围绕的区域 (Medium)
 */
class Solution {

    private char[][] board;
    private int m;
    private int n;

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, 1, 0, -1};

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        // left most col, right most col
        for(int r = 0; r < m; r++) {
            dfs(r, 0);
            dfs(r, n - 1);
        }

        // top most row (exclude leftmost col, rightmost col), 
        // bottom most row (exclude leftmost col, rightmost col)
        for(int c = 1; c < n - 1; c++) {
            dfs(0, c);
            dfs(m - 1, c);
        }

        // All bad ones should be already marked as 'A'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if(board[row][col] == 'X' || board[row][col] == 'A') return;
        board[row][col] = 'A';
        for(int i = 0; i < 4; i++) {
            dfs(row + dy[i], col + dx[i]);
        }

    }
}