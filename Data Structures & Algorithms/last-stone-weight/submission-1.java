class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b- a);
        for (int num : stones) {
            pq.offer(num);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int res= a - b;
            if (res > 0) {
                pq.offer(res);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();

    }
}
