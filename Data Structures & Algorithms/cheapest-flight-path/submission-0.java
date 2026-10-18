class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < k + 1; i ++ ) {
            int[] backup = dist.clone();
            for (int[] e : flights) {
                dist[e[1]] = Math.min(dist[e[1]], e[2] + backup[e[0]]);
            }
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }
}
