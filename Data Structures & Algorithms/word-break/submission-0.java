class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n];
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 0; i < n; i ++ ) {
            if (set.contains(s.substring(0, i + 1))) {
                // System.out.println("now i is" + i);

                f[i] = true;
                continue;
            }
            for (int j = i; j >=0 ;j --) {
                // if (i == 7 && j == 3 ) {
                // System.out.println("now i is " + i + " and j is " + j);
                // System.out.println("and f[j] is " + f[j]);
                // System.out.println("and sub is " + s.substring(j, i + 1));
                // }
                if (f[j] && set.contains(s.substring(j + 1, i + 1)))
                {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n - 1];
    }

}
