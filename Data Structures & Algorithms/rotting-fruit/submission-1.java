class Solution {
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int min = 0;
        int good = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i ++ ) {
            for (int j = 0; j < grid[0].length;j ++ ) {
                if (grid[i][j] == 1) {
                    good ++;
                }
                else if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                    
                }
            }   
        }
        if (good ==0) {
            return 0;
        }
        while (!q.isEmpty()) {
            int si = q.size();
            while (si -- > 0) {
                int[] poll = q.poll();
                for (int i = 0; i < 4; i ++ ) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    if (nx >= 0 && nx < grid.length && ny >=0 && ny <grid[0].length) {
                        if (grid[nx][ny] == 1) {
                            q.offer(new int[] {nx, ny});
                            grid[nx][ny] = 2;
                            good --;
                        }
                    }
                }
            }
            min ++;
        }
        return good == 0 ? min - 1: -1;

    }
}
