class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] st = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (st[nums[i]] == 1) {
                return nums[i];
            }
            st[nums[i]] = 1;
        }
        return -1;
    }
}
