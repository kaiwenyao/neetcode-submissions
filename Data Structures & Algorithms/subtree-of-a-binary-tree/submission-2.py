# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        def isSameTree(p, q):
            if p is None or q is None:
                return p is q
            return p.val == q.val and isSameTree(p.left, q.left) and isSameTree(p.right, q.right)

        def dfs(root):
            if root is None:
                return False

            return isSameTree(root, subRoot) or dfs(root.left) or dfs(root.right)
                
        return dfs(root)