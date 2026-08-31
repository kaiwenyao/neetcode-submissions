class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                f[i][j] = amount + 1;
            }
        }
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= coins[i - 1]) {
                    f[i][j] = Math.min(f[i][j], 1 + f[i][j - coins[i - 1]]);
                }
            }
        }
        return f[n][amount] == amount + 1 ? -1 : f[n][amount];
    }
}
