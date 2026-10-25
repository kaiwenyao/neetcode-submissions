# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if root is None:
            return []
        res = []
        q = deque()
        q.append(root)
        while q:
            si = len(q)
            tmp = []
            for _ in range(si):
                poll = q.popleft()
                tmp.append(poll.val)
                if poll.left is not None:
                    q.append(poll.left)
                if poll.right is not None:
                    q.append(poll.right)
            res.append(tmp)
        return res

