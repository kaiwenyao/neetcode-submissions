class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1= text1.length();
        int n2 = text2.length();
        int[][] f = new int[n1 + 1][n2 + 1];
        f[0][0] = 0;

        for (int i = 1; i <= n1; i ++ ) {
            for (int j = 1; j <= n2; j ++ ) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = 1 + f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.max(
                        f[i - 1][j - 1],
                        Math.max(
                            f[i][j - 1],
                            f[i - 1][j]
                        )
                    );
                    
                }
            }
        }
        return f[n1][n2];
        
    }
}
