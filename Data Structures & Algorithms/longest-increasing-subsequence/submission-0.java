class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n ; i++ ) {
            for (int j = 0; j < i;j ++ ) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int max = f[0];
        for (int num : f) {
            max = Math.max(num, max);
        }
        return max;
    }
}
