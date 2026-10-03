class Solution {
    public boolean checkValidString(String s) {
        int lo= 0;
        int hi = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++ ) {
            if (chs[i] == '(')
            {
                lo ++;
                hi ++;
            }
            else if (chs[i] == ')')
            {
                lo --;
                hi --;
            }
            else {
                lo --;
                hi ++;
            }
            if (hi < 0) {
                return false;
            }

            lo = Math.max(lo, 0);
        }

        return lo == 0;
    }
}
