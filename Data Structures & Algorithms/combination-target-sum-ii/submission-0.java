class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    HashSet<Integer> set;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        set = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int st) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        if (target < 0) {
            return;
        }

        for (int i = st; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !set.contains(candidates[i])) {
                continue;
            }
            path.add(candidates[i]);
            set.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            set.remove(candidates[i]);
            path.removeLast();
        }
    }
}
