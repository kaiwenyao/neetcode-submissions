class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        int[][] f = new int[n][2];
        f[0][0] = 0;
        f[0][1] = nums[0];
        f[1][0] = f[0][1];
        f[1][1] = nums[1];
        for (int i = 2; i < n; i ++ ) {
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
            f[i][1] = nums[i] + f[i - 1][0];
        }
        return Math.max(f[n - 1][0], f[n - 1][1]);

        

    }
}
