class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f3f;
        boolean[] st = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : times) {
            g[e[0]].add(new int[] {e[1], e[2]});
        }
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            if (t == -1 || dist[t] == INF) {
                return -1;
            }
            st[t] = true;

            for (int[] ne : g[t]) {
                dist[ne[0]] = Math.min(dist[ne[0]], dist[t] + ne[1]);
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
