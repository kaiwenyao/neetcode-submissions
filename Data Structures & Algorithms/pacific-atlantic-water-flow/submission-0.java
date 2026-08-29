class Solution {
    boolean[][] p;
    boolean[][] a;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        p = new boolean[n][m];
        a = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            p[0][i] = true;
            dfsp(0, i, heights);
        }
        for (int i = 0; i < n; i++) {
            p[i][0] = true;
            dfsp(i, 0, heights);
        }
        for (int i = 0; i < m; i++) {
            a[n - 1][i] = true;
            dfsa(n - 1, i, heights);
        }
        for (int i = 0; i < n; i++) {
            a[i][m - 1] = true;
            dfsa(i, m - 1, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfsp(int x, int y, int[][] h) {
        p[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < h.length && ny >= 0 && ny < h[0].length) {
                if (h[nx][ny] >= h[x][y] && !p[nx][ny]) {
                    dfsp(nx, ny, h);
                }
            }
        }
    }
    public void dfsa(int x, int y, int[][] h) {
        a[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < h.length && ny >= 0 && ny < h[0].length) {
                if (h[nx][ny] >= h[x][y] && !a[nx][ny]) {
                    dfsa(nx, ny, h);
                }
            }
        }
    }
}
