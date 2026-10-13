class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();

        int n = s1.length();
        int m = s2.length();
        if (n + m != ss3.length) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 && ss1[i - 1] == ss3[i + j - 1] && f[i - 1][j]) {
                    f[i][j] = true;
                } else if (j > 0 && ss2[j - 1] == ss3[i + j - 1] && f[i][j - 1]) {
                    f[i][j] = true;
                }
            }
        }
        return f[n][m];
    }
}
