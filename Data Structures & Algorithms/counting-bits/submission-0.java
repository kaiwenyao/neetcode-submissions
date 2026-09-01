class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <n + 1; i ++ ) {
            int cnt = 0;
            int cur = i;
            while (cur > 0 ) {
                if ((cur & 1) == 1 ) {
                    cnt ++;
                }
                cur >>= 1;
            }
            res[i] = cnt;
        }
        return res;
    }
}
