class Solution {
    List<String> path;
     List<List<String>> res;
    public List<List<String>> partition(String s) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int st) {
        if (st >= s.length()) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = st + 1; i <= s.length(); i ++) {
            if (isValid(s.substring(st, i))) {
                path.add(s.substring(st, i));
                dfs(s, i);
                path.removeLast();
            }
        }

    }
    public boolean isValid(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r ) {
            if (s.charAt(l) != s.charAt(r) ) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
