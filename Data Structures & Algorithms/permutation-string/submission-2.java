class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() ) {
            return false;
        }
        int[] st = new int[26];
        for (char c : s1.toCharArray())
        {
            st[c - 'a'] ++;
        }
        int n = s1.length();
        int[] st2 = new int[26];
        for (int i = 0; i < n; i++ ) {
            st2[s2.charAt(i) - 'a'] ++;
        }
        if (isValid(st, st2) ) {
            return true;
        }
        for (int i = 1; i <= s2.length() - n; i++) {
            st2[s2.charAt(i - 1) - 'a'] --;
            st2[s2.charAt(i + n - 1) - 'a'] ++;
            if (isValid(st, st2)) {
                return true;
            }
        }
        return false;
    }
    public boolean isValid(int[] st1, int[] st2) {
        for (int i = 0; i < 26;i ++ ) {
            if (st1[i] != st2[i]) {
                return false;
            }
        }
        return true;
    }
}
