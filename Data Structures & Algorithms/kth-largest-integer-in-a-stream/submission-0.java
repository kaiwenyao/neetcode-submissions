class KthLargest {
    PriorityQueue<Integer> pq;
    int k ;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a, b) -> b - a);
        this.k = k;

        for (int num : nums) {
            pq.offer(num);
        }
    }

    public int add(int val) {
        pq.offer(val);

        int si = k;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (si-- > 1) {
            tmp.add(pq.poll());
        }
        int target = pq.peek();
        for (int t : tmp) {
            pq.offer(t);
        }
        return target;
    }
}
