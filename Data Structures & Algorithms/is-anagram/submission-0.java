class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[(int) (c - 'a')] ++;
        }
        int[] tchars = new int[26];
        for (char c : t.toCharArray()) {
            tchars[(int) (c - 'a')] ++;
        }
        for (int i = 0; i < 26; i ++ ) {
            if (tmp[i] != tchars[i]) {
                return false;
            }
        }
        return true;

    }
}
