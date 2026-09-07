class Solution {
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    boolean[][] st;
    public void islandsAndTreasure(int[][] grid) {
        st = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    st = new boolean[grid.length][grid[0].length];
                    bfs(grid, i, j);
                }
            }
        }
    }

    public void bfs(int[][] g, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {x, y});

        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int a = cur[0];
                int b = cur[1];
                g[a][b] = Math.min(g[a][b], depth);
                for (int i = 0; i < 4; i++) {
                    int nx = a + dx[i];
                    int ny = b + dy[i];
                    if (nx >= 0 && nx < g.length && ny >= 0 && ny < g[0].length) {
                        if (g[nx][ny] > 0 && !st[nx][ny]) {
                            st[nx][ny] = true;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            depth++;
        }
    }
}
