class Solution {
    boolean flag = false;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    boolean[][] st;
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        st = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bfs(i, j, 0, chars, board, st);
            }
        }
        return flag;
    }
    public void bfs(int x, int y, int start, char[] chars, char[][] board, boolean[][] st) {
        if (chars[start] != board[x][y]) {
            return;
        }
        if (start == chars.length - 1) {
            flag = true;
            return;
        }
        st[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !st[nx][ny]) {
                bfs(nx, ny, start + 1, chars, board, st);
            }
        }
        st[x][y] = false;
    }
}
