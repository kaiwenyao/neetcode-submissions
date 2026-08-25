class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length() + "#" + s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        char[] chars = str.toCharArray();
        List<String> res = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < chars.length; i ++ ) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                k = k * 10 + c - '0';
            }
            if (c == '#') {
                StringBuilder sb = new StringBuilder();
                int j = i + 1;
                for (; j < i + 1 + k; j ++ ) {
                    sb.append(chars[j]);
                }
                res.add(sb.toString());
                k = 0;
                i = j - 1;
            }
        }
        return res;
    }
}
