class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        // 桶：下标 = 频率，值 = 该频率的所有数字
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(key);
        }

        // 从高频率往低扫，收集前 k 个
        int[] res = new int[k];
        int idx = 0;
        for (int f = bucket.length - 1; f >= 0 && idx < k; f--) {
            if (bucket[f] == null) continue;
            for (int num : bucket[f]) {
                res[idx++] = num;
                if (idx == k) break;
            }
        }
        return res;
    }
}
