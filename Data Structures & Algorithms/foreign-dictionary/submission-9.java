class Solution {
    public String foreignDictionary(String[] words) {
        List<Integer>[] g = new ArrayList[26];
        int[] in = new int[26];
        for (int i = 0; i < 26; i++) {
            g[i] = new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> allSet = new HashSet<>();
        int n = words.length;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                allSet.add(c - 'a');
            }
        }
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < words[i].length() && j < words[i - 1].length() && words[i].charAt(j) == words[i - 1].charAt(j)) {
                j++;
                if (j < words[i - 1].length() && j >= words[i].length()) {
                    return "";
                }
            }
            if (j == words[i].length() || j == words[i- 1].length()) {
                continue;
            }
            char from = words[i - 1].charAt(j);
            char to = words[i].charAt(j);
            g[from - 'a'].add(to - 'a');
            in[to - 'a']++;
            set.add(from - 'a');
            set.add(to - 'a');
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (set.contains(i) && in[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append((char) ('a' + cur));
            allSet.remove(cur);
            cnt++;
            for (int nei : g[cur]) {
                in[nei]--;
                if (in[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        if (cnt != set.size()) {
            return "";
        }
        Iterator<Integer> it = allSet.iterator();
        while (it.hasNext()) {
            int c = it.next();
            it.remove(); // 用迭代器删，而不是 allSet.remove
            sb.append((char) (c + 'a'));
        }
        return sb.toString();
    }
}
