class Solution {
    public List<Integer> partitionLabels(String s) {
            int[] last = new int[26];
    char[] chs = s.toCharArray();
    for (int i = 0; i < chs.length; i++) last[chs[i] - 'a'] = i;

    List<Integer> res = new ArrayList<>();
    for (int i = 0, start = 0, end = 0; i < chs.length; i++) {
        end = Math.max(end, last[chs[i] - 'a']);
        if (i == end) {
            res.add(end - start + 1);
            start = i + 1;
        }
    }
    return res;
    }
}
