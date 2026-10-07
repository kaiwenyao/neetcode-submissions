class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        if (digits[n - 1] < 9) {
            res = Arrays.copyOf(digits, n);
            res[n - 1] ++;
        }
        else {
            int i = n - 1;
            while (i >= 0 && digits[i] == 9) {
                i --;
            }
            if (i == -1) {
                res = new int[n + 1];
                Arrays.fill(res, 0);
                res[0] = 1;
            }
            else {
                res = Arrays.copyOf(digits, n);
                res[i] ++;
                for (int j = i + 1; j < n; j ++ ) {
                    res[j] = 0;
                }
            }
        }
        return res;
    }
}
