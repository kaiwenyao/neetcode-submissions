class Solution {
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();

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
            if (candidates[i] > target) break;
            if (i > st &&  candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }
}
