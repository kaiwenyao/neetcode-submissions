# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        MAX = float('inf')
        MIN = float('-inf')
        
        def dfs(root, upper, lower):
            if root is None:
                return True
            
            return lower < root.val < upper and dfs(root.left, min(root.val, upper), lower) and dfs(root.right, upper, max(root.val, lower))
            
        return dfs(root, MAX, MIN)