class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        for (int[] e : times) {
            g[e[0]].add(new int[] {e[1], e[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[] {k, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cur = poll[0];
            int d = poll[1];
            if (dist[cur] < d)
                continue;
            dist[cur] = d;
            for (int[] ne : g[cur]) {
                if (dist[ne[0]] > dist[cur] + ne[1]) {
                    dist[ne[0]] = dist[cur] + ne[1];
                    q.offer(new int[] {ne[0], dist[ne[0]]});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
