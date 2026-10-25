# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        res = 0
        
        cur = 0
        def dfs(root):
            nonlocal cur
            nonlocal res
            if root is None:
                res = max(res, cur)
                return
            cur += 1
            dfs(root.left)
            dfs(root.right)
            cur -= 1
        dfs(root)
        return res
            