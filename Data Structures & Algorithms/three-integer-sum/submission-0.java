class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                if (left + right == target) {
                    res.add(new ArrayList<>(Arrays.asList(left, right, nums[i])));
                    while (l < r && nums[l] == left) l++;
                    while (l < r && nums[r] == right) r--;
                } else if (left + right > target) {
                    r--;
                } else {
                    l++;
                }
            }
            while (i < nums.length && target + nums[i] == 0 ) {
                i ++;
            }
            i --;
        }
        return res;
    }
}
