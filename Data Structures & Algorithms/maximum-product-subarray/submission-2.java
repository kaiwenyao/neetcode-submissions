class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1 ) {
            return nums[0];
        }
        int[] maxf = new int[n];
        int[] minf = new int[n];
        int res = nums[0];
        maxf[0] = nums[0];
        minf[0] = minf[0];
        for (int i = 1; i < n ; i ++ ) {
            
            maxf[i] = Math.max(
                nums[i],
                Math.max(
                    maxf[i - 1] * nums[i],
                    minf[i - 1] * nums[i]
                )
            );
            minf[i] = Math.min(
                nums[i],
                Math.min(
                    maxf[i - 1] * nums[i],
                    minf[i - 1] * nums[i]
                )
            );
            res = Math.max(res, maxf[i]);
        }
        return res;
    }
}
