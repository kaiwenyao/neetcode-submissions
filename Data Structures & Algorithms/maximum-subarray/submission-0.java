class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int n = nums.length;
        int res = -10010;
        for (int i = 0; i < n; i ++ ) {
            cur += nums[i];
            if (cur < nums[i]) {
                cur = nums[i];
            }
            res = Math.max(res, cur);
        } 
        return res;
    }
}
