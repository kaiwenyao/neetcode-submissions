class Solution {
    boolean[] used;
    List<List<Integer>> res;
    List<Integer> path;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        res = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[n];
        dfs(nums);
        return res;
    }

    public void dfs(int[] nums) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
