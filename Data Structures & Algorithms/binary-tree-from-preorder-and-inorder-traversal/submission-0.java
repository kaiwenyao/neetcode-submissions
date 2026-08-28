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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preSt, int preEd, int inSt, int inEd) {
        if (preSt > preEd) {
            return null;
        }
        int val = preorder[preSt];
        TreeNode root = new TreeNode(val);
        int idx = -1;
        for (int i = inSt; i <= inEd;i ++ ) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }
        int leftLen = idx - inSt;
        root.left = build(preorder, inorder, preSt + 1, preSt + leftLen, inSt, inSt + leftLen - 1);
        root.right = build(preorder, inorder, preSt + leftLen + 1, preEd, idx + 1, inEd);
        return root;
    }
}
