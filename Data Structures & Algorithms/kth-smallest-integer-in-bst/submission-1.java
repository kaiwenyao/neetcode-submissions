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
    int cur = 0;
    int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        cur++;
        if (k == cur) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
