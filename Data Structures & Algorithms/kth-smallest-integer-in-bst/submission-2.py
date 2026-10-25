# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        cur = 0
        res = -1
        def dfs(root):
            if root is None:
                return
            dfs(root.left)
            nonlocal cur
            nonlocal res
            cur += 1
            if cur == k:
                res = root.val
            dfs(root.right)
            

        dfs(root)
        return res