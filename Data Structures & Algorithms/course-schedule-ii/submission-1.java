class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] in = new int[n];
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n;i ++) {
            g[i] = new ArrayList<>();
        }

        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            g[from].add(to);
            in[to] ++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n;i ++ ) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        int[] res =new int[n];
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[cnt ++] = cur;
            for (int ne : g[cur]) {
                in[ne] --;
                if (in[ne] == 0) {
                    q.offer(ne);
                }
            }
        }
        return cnt == n ? res : new int[] {};


    }
}
