class Solution {
    // 最快的是中心扩散法
    public String longestPalindrome(String s) {
        int st = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++ ) {
            int len1 = isP(i, i, s);
            int len2 = isP(i, i + 1, s);
            if (Math.max(len1, len2) > len) {
                len = Math.max(len1, len2);
                st = i - (len - 1) / 2;
            }
        }
        return s.substring(st, st + len);
    }

    public int isP(int l, int r, String s) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
                continue;
            }
            break;
        }

        return r- l  - 1;

    }
}
