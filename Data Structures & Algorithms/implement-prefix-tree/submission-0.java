class PrefixTree {
    public class Node {
        int val;
        Node[] children;
        public Node() {
            this.val = 0;
            this.children = new Node[26];
        }
    }
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node p = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new Node();
            }
            p = p.children[c - 'a'];
        }
        p.val++;
    }

    public boolean search(String word) {
        Node p = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        if (p.val != 0) 
        return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        Node p = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.children[c - 'a'] == null) {
                return false;
            }
            p = p.children[c - 'a'];
        }
        return true;
    }
}
