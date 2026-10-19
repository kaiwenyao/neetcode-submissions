class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : cnt) {
            if (c != 0) {
                pq.offer(c);
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int cycle = 0;
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    int cur = pq.poll();
                    if (cur > 1)
                        tmp.add(cur - 1);
                    cycle++;
                }
            }
            for (int task : tmp) pq.offer(task);
            time += pq.isEmpty() ? cycle : (n + 1);
        }
        return time;
    }
}
