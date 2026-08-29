class Solution {
    int res = 0;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }
    public void dfs(int x, int y, char[][] g) {
        if (g[x][y] == '1') {
            g[x][y] = '0';
        } else {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < g.length && ny >= 0 && ny < g[0].length) {
                dfs(nx, ny, g);
            }
        }
    }
}
