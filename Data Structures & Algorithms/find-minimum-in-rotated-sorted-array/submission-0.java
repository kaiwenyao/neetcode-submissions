class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] < nums[n - 1]) {
            return nums[0];
        }
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[r]) {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
            else {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
        }
        return min;
    }
}
