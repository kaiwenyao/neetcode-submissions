/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> m = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    public Node dfs(Node node) {
        if (node == null ) {
            return null;
        }
        if (m.containsKey(node)) {
            return m.get(node);
        }

        Node newNode = new Node(node.val);
        m.put(node, newNode);

        for (Node n : node.neighbors) {
            newNode.neighbors.add(dfs(n));
        }
        return newNode;
    }
}