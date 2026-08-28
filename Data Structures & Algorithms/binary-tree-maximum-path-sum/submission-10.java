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
    int res = -1005;
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null ) {
            return root.val;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1005;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int tmp = root.val;

        if (root.val + left > tmp) {
            tmp = root.val + left;
        }
        if (root.val + right > tmp) {
            tmp = root.val + right;
        }
        res = Math.max(res, root.val + left + right);
        res = Math.max(res, tmp);
        return tmp;
    }
}
