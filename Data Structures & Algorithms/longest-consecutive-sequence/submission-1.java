class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!s.contains(nums[i] - 1)) {
                int k = nums[i];
                int len = 0;
                while (s.contains(k ++)) {
                    len ++;
                }
                res = Math.max(len, res);
            }
        }
        return res == -1 ? 0 : res;
    }
}
