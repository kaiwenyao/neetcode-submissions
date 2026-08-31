class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];

        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c != '0') {
                f[i] += f[i - 1];
            }
            int two = (s.charAt(i - 2) - '0') * 10 + (c - '0');
            if (two >= 10 && two <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
