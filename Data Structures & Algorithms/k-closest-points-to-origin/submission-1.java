class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> { return dis(b[0], b[1]) - dis(a[0], a[1]); });
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // int res = dis(pq.peek()[0], pq.peek()[1]);
        // ArrayList<int[]> tmp = new ArrayList<>();
        // while (pq.size() > 0 && res == dis(pq.peek()[0], pq.peek()[1])) {
        //     tmp.add(pq.poll());
        // }
        // return tmp.toArray(new int[0][]);

        int[][] res = new int[k][];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
    public int dis(int x, int y) {
        return x * x + y * y;
    }
}
