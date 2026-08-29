class Solution {
    boolean[] st;
    boolean[] onPath;
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        st = new boolean[n];
        onPath = new boolean[n];
        hasCycle = false;

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];

            g[from].add(to);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, g);
        }

        return !hasCycle;
    }
    public void dfs(int cur, List<Integer>[] g) {
        if (hasCycle) {
            return;
        }

        if (onPath[cur]) {
            hasCycle = true;
            return;
        }

        if (st[cur]) {
            return;
        }
        st[cur] = true;

        onPath[cur] = true;
        for (int n : g[cur]) {
            dfs(n, g);
        }
        onPath[cur] = false;
    }
}
