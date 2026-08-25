class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 数组计数（加偏移量处理负数）
        int OFFSET = 1000; // 对应 [-1000, 1000] 范围
        int[] freq = new int[2001];
        for (int n : nums) {
            freq[n + OFFSET]++; // 按数值计数，负数也能当下标
        }

        // 2. 大小 K 的最小堆（堆顶是最小频率，超出就挤掉）
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < 2001; i++) {
            if (freq[i] == 0)
                continue; // 没出现的数字跳过
            heap.offer(new int[] {i - OFFSET, freq[i]}); // 存回原数字 + 频率
            if (heap.size() > k)
                heap.poll(); // 挤掉频率最小的
        }

        // 3. 堆里剩下的就是频率最高的 K 个
        int[] res = new int[k];
        int idx = 0;
        while (!heap.isEmpty()) {
            res[idx++] = heap.poll()[0];
        }
        return res;
    }
}
