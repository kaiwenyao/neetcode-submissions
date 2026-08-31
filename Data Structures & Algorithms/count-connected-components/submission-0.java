class Solution {
    int[] p;
    public int countComponents(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; i ++ ) {
            p[i] = i;
        }
        int ans = 0;
        for (int[] edge : edges ) {
            int from = edge[0];
            int to = edge[1];
            p[find(from)] = find(to);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i < n; i ++ ) {
            if (!set.contains(find(i))) {
                set.add(find(i));
                ans ++;
            }
        }
        return ans;

    }
    public int find(int x) {

        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
