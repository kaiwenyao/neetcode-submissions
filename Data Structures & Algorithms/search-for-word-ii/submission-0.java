class Solution {
    List<String> res;
    public class Node {

        String w;
        Node[] ch;
        public Node() {
            this.w = null;
            this.ch = new Node[26];
        }
    }
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, 1, 0, -1};
    Node root;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        root = new Node();
        for (String s : words) {
            Node p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.ch[c - 'a'] == null) {
                    p.ch[c - 'a'] = new Node();
                }
                p = p.ch[c - 'a'];
            }
            p.w = s;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bfs(i, j, board, root);
            }
        }

        return res;
    }

    public void bfs(int x, int y, char[][] g, Node cur) {
        char c = g[x][y];
        if (c == '#')
        return ;
        Node nxt = cur.ch[c - 'a'];
        if (nxt == null ) {
            return;
        }
        if (nxt.w != null) {
            res.add(nxt.w);
            nxt.w = null;

        }
        g[x][y] = '#';

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < g.length && ny >= 0 && ny < g[0].length) {
                bfs(nx, ny, g, cur.ch[c - 'a']);
            }
        }
        g[x][y] = c;
    }
}
