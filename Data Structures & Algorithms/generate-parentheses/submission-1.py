class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        res = []
        path = ""

        def dfs(l: int, r: int):
            nonlocal path
            if len(path) == n * 2:
                res.append(path)
                return
            if l < n:
                path += "("
                dfs(l + 1, r)
                path = path[:-1]
            if l > r and r < n:
                path += ")"
                dfs(l, r + 1)
                path = path[:-1]
        dfs(0, 0)
        return res

            
            