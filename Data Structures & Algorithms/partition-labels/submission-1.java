class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] st = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(st[i], -1);
        }

        char[] chs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (st[chs[i] - 'a'][0] == -1) {
                st[chs[i] - 'a'][0] = i;
            }
            st[chs[i] - 'a'][1] = i;
        }
        Arrays.sort(st, (a, b) -> { return a[0] - b[0]; });
        int end = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (st[i][0] == -1) {
                continue;
            }
            if (end < st[i][0]) {
                res.add(end - start + 1);
                start = st[i][0];
                end = st[i][1];
            } else {
                end = Math.max(end, st[i][1]);
            }
        }
        res.add(end - start + 1);

        return res;
    }
}
