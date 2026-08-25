class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++ ) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
                else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        String ss = sb.toString();
        int l = 0;
        int r = ss.length() - 1;
    
        while (l < r) {
            if (ss.charAt(l) != ss.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
