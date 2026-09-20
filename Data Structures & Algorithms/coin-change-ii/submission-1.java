class Solution {
    int cnt = 0;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i ++ ) {
            for (int j = 0; j <= amount; j ++ ) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] = f[i - 1][j] + f[i][j - coins[i - 1]];
                }
            }
        }
        return f[n][amount];
        
    }

}
