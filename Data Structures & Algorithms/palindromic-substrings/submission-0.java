class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                char a = s.charAt(i);
                char b = s.charAt(j);
                if (a == b) {
                    if (i == j || i == j - 1) {
                        ans++;
                        f[i][j] = true;
                    } else if (f[i + 1][j - 1]) {
                        ans++;
                        f[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }
}
