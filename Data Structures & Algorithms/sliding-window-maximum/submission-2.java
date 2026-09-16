class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
             int n = nums.length;
        if (k == 1) return nums.clone();

        int[] res = new int[n - k + 1];
        int[] q = new int[n];          // 单调队列：存下标，对应 nums 值单调递减
        int head = 0, tail = 0;        // 有效区间 [head, tail)，head 是队首(最大值)

        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            // 1) 队首滑出窗口则弹出（窗口为 [i-k+1, i]）
            if (head < tail && q[head] <= i - k) head++;

            // 2) 维护单调递减：比当前小或相等的队尾元素再也当不了最大值
            while (head < tail && nums[q[tail - 1]] <= cur) tail--;

            // 3) 当前下标入队
            q[tail++] = i;

            // 4) 窗口成型后，队首即窗口最大值
            if (i >= k - 1) res[i - k + 1] = nums[q[head]];
        }
        return res;
    }
}
