class Solution {
    public int characterReplacement(String s, int k) {
        int[] tmp = new int[26];
        int l = 0;
        int r = 0;
        int res = 0;
        int max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            tmp[c - 'A']++;
            max = Math.max(max, tmp[c - 'A']);
            while (r - l - max > k) {
                char d = s.charAt(l);
                l++;
                tmp[d - 'A']--;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
