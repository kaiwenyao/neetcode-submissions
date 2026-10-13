class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (s1[i - 1] == s2[j - 1])
                {
                    f[i][j] = f[i - 1][j - 1];
                }
                else {
                    int a = f[i - 1][j] + 1;
                    int b = f[i][j - 1] + 1;
                    int c = f[i - 1][j - 1] + 1;
                    f[i][j] = Math.min(Math.min(a, b), c);
                }
            }
        }
        return f[n][m];
    }
}
