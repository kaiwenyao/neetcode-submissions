class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int max = 0;
        for (char c : tasks) {
            cnt[c - 'A']++;
            max = Math.max(max, cnt[c - 'A']);
        }
        int k = 0;
        for (int c : cnt) {
            if (c == max) {
                k++;
            }
        }
        int total = tasks.length;
        int other = total - max * k;
        int empty = (max - 1) * (n - (k - 1));
        if (other <= empty) {
            return (max - 1) * (n + 1) + k;
        } else {
            return total;
        }
    }
}
