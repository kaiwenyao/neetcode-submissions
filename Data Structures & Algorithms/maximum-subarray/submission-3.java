class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++ )
        {
            if (cur + nums[i] < nums[i]) {
                cur = nums[i];
            }
            else {
                cur += nums[i];
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
