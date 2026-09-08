class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        res= new ArrayList<>();
        path = new ArrayList<>();
        dfs(nums, 0);
        return res;
 }


    public void dfs(int[] nums, int st) {


        res.add(new ArrayList<>(path));
        for (int i = st;i < nums.length; i ++ ){ 
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
        

    }
    
}
