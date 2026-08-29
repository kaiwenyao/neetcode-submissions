class WordDictionary {
    public class Node {
        int val;
        Node[] ch;
        public Node() {
            this.val = 0;
            this.ch = new Node[26];
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.ch[c - 'a'] == null) {
                p.ch[c - 'a'] = new Node();
            }
            p = p.ch[c - 'a'];
        }
        p.val++;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int start, Node p) {
        if (p == null) {
            return false;
        }
        if (start == word.length()) {
            if (p.val == 0)
                return false;
            return true;
        }
        char c = word.charAt(start);
        if (c != '.') {
            return dfs(word, start + 1, p.ch[c - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (dfs(word, start + 1, p.ch[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
