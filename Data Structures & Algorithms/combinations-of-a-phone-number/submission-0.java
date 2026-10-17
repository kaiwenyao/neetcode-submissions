class Solution {
    String[] letters;
    List<String> res;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        letters = new String[] {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        sb = new StringBuilder();
        dfs(digits, 0);
        return res;
    }

    public void dfs(String s, int st) {
        if (st >= s.length()) {
            res.add(sb.toString());
            return ;
        }
        String cur = letters[s.charAt(st) - '2'];
        for (int i = 0; i < cur.length(); i ++ ) {
            sb.append(cur.charAt(i));
            dfs(s, st + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        

    }



}
