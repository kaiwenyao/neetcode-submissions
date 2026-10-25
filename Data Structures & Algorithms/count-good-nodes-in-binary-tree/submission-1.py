# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        res = 0
        def dfs(root, big):
            if root is None:
                return
            nonlocal res
            if root.val >= big:
                res += 1
                dfs(root.left, root.val)
                dfs(root.right, root.val)
            else:
                dfs(root.left, big)
                dfs(root.right, big)
        dfs(root, -101)
        return res