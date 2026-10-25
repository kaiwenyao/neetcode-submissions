# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = 0
        def dfs(root):
            nonlocal res
            if root is None:
                return 0
            l = dfs(root.left)
            r = dfs(root.right)
            cur = l + r
            res = max(res, cur)
            return 1 + max(l, r)
        dfs(root)
        return res