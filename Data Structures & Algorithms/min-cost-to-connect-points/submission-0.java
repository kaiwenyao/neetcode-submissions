class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        boolean[] st = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            res += dist[t];
            st[t] = true;

            for (int j = 0; j < n; j++) {
                int d =
                    Math.abs(points[j][0] - points[t][0]) + Math.abs(points[j][1] - points[t][1]);
                if (d < dist[j]) {
                    dist[j] = d;
                }
            }
        }
        return res;
    }
}
