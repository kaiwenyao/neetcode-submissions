class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] tmp = new int[256];

        int l = 0;
        int r = 0;

        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            tmp[c]++;
            while (tmp[c] > 1) {
                char d = s.charAt(l);
                tmp[d]--;
                l++;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
