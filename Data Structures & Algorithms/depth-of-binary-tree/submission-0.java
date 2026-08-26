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

class Solution {
    int res = -1;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res + 1;
    }
    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        res = Math.max(res, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
