class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] a = new int[m];
        int[] b = new int[n];
        int[] res = new int[m + n];
        for (int i = 0; i < m; i++) {
            a[i] = num1.charAt(m - 1 - i) - '0';
        }
        for (int i = 0; i < n; i++) {
            b[i] = num2.charAt(n - 1 - i) - '0';
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i + j] += a[i] * b[j];
            }
        }
        int carry = 0;
        for (int i = 0; i < m + n; i++) {
            int cur = carry + res[i];
            res[i] = cur % 10;
            carry = cur / 10;
        }
        StringBuilder sb = new StringBuilder();
        int idx = m + n - 1;
        while (idx >= 0 && res[idx] == 0) {
            idx--;
        }
        if (idx == -1) {
            return "0";
        }
        for (int i = idx; i >= 0; i--) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
