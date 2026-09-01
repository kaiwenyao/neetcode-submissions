class Solution {
    public int reverseBits(int n) {
        int res= 0;
        int cnt = 32;
        while (cnt -- > 0) {
            res = (res << 1 ) | (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
