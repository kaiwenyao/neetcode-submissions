class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum)
            return 0;
        if (((target + sum) & 1) != 0)
            return 0;
        target = (target + sum) / 2;

        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                f[j] += f[j - nums[i]];
            }
        }
        return f[target];
    }
}
