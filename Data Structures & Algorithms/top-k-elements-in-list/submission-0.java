class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });

        int[] tmp = new int[2001];
        for (int i = 0; i < nums.length; i ++ ) {
            tmp[nums[i] + 1000] ++;
        }
        for (int i = 0; i < 2001;i ++ ) {
            if (tmp[i] != 0) {
                pq.offer(new int[] {i - 1000, tmp[i]});
            }
        }
        int[] res= new int[k];
        for (int i = 0; i < k; i ++ ) {
            res[i] = pq.poll()[0];
        }
        return res;

    }
}