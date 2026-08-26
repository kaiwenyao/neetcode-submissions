class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l);
                if (need.containsKey(d)) {
                    if (map.get(d).equals(need.get(d))) {
                        valid -- ;
                    }
                    map.put(d, map.get(d) - 1);
                }
                l ++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
