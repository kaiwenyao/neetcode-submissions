class Solution {
    int[] p;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (find(from) == find(to)) {
                return false;
            }
            p[find(from)] = find(to);
        }
        return true;
    }
    public int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
