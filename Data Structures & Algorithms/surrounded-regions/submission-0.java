class Solution {
    int[] st;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        st = new int[n * m];
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < m; i ++ ){
            for (int j = 0; j < n; j ++ ) {
                if (board[i][j] == 'O' && st[i * n + j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] g, int x, int y) {
        if (g[x][y] != 'O') {
            return;
        }

        int m = g.length;
        int n = g[0].length;
        if (st[y + x * n] == 1) {
            return;
        }
        st[y + x * n] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                dfs(g, nx, ny);
            }
        }
    }
}
