class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int range = Math.min(nums[0], nums.length - 1);
        if (range >= nums.length - 1) {
            return 1;
        }
        int step = 1;
        int i = 1;
        while (i < nums.length) {
            int newRange = 0;
            int j = i;
            for (; j <= Math.min(range, nums.length - 1); j ++) {
                newRange = Math.max(newRange, j + nums[j]);
            }
            step ++;
            if (newRange >= nums.length - 1) {
                return step ;
            }
            range = newRange;
            i = j;
        }
        return step ;
    }
}
