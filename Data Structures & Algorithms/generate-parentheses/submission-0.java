class Solution {
    List<String> res;
    StringBuilder sb;
    int l = 0;
    int r =0;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        dfs(n);
        return res;
        
    }
    public void dfs(int n) {
        if (l == n && r == n)
        {
            res.add(sb.toString());
            return ;
        }

        if (l < n) {
            sb.append("(");
            l ++;
            dfs(n);
            l --;
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            r ++;
            dfs(n);
            r --;
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
