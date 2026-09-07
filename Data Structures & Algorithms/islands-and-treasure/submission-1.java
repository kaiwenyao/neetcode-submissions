class Solution {
    public void islandsAndTreasure(int[][] grid) {
               int m = grid.length, n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 多源：所有宝箱同时入队，距离都是 0
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0)
                    q.offer(new int[]{i, j});

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nx = cur[0] + d[0], ny = cur[1] + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 只有"未被访问的陆地"才入队：
                // 陆地初始值正好是 INF = 2^31-1 = Integer.MAX_VALUE，
                // 被赋值过的格子不再是这个值，天然当 visited 用
                if (grid[nx][ny] != Integer.MAX_VALUE) continue;

                grid[nx][ny] = grid[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
