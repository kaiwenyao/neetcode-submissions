class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n - k + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (i < n) {
            if (!q.isEmpty() && i - q.peek() >= k) {
                q.poll();
            }
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                res[j] = nums[q.peek()];
                j ++;
            }
            i ++;
        }
        return res;



    }
}
