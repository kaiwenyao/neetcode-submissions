class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false; // 长度不同直接排除

        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;

        // 所有位置都归零才是 anagram
        for (int n : count)
            if (n != 0)
                return false;
        return true;
    }
}
