# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        res = False
        def isSameTree(p, q):
            if p is None or q is None:
                return p is q
            return p.val == q.val and isSameTree(p.left, q.left) and isSameTree(p.right, q.right)

        def dfs(root):
            if root is None:
                return
            if root.val == subRoot.val:
                isSub = isSameTree(root, subRoot)
                if isSub:
                    nonlocal res
                    res = True
                    return
            dfs(root.left)
            dfs(root.right)
                
                
        dfs(root)
        return res