class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (m.containsKey(k)) {
                return new int[] {m.get(k), i};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
