/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }
    public void dfs(TreeNode root) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> nodes = new ArrayList<>();
        for (String part : data.split(",")) {
            nodes.add(part);
        }
        return ddfs(nodes);
    }
    public TreeNode ddfs(List<String> nodes) {
        String cur = nodes.removeFirst();
        if (cur.length() == 0) {
            return null;
        }
        if (cur.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = ddfs(nodes);
        root.right = ddfs(nodes);
        return root;
    }
}
