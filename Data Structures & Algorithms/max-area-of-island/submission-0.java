class Solution {
    int cnt = 0;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cnt = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        return max;
    }

    public void dfs(int[][] g, int x, int y) {
        cnt ++;
        g[x][y] = 0;

        for (int i = 0; i < 4; i ++ ){
            int nx= x + dx[i];
            int ny= y + dy[i];
            if (nx >= 0 && nx < g.length && ny >=0 && ny < g[0].length) {
                if (g[nx][ny] == 1) {
                     dfs(g, nx, ny);            
                }
            }
        }
        

    }
}
