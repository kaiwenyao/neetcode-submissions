class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        col = [False] * n
        u = [False] * (2 * n)
        v = [False] * (2 * n)
        path: list[str] = []
        res: list[list[str]] = []

        def dfs(x: int) -> None:
            if x == n:
                res.append(list(path))

            for i in range(n):
                if not col[i] and not u[x - i + n - 1] and not v[x + i]:
                    col[i] = u[x - i + n - 1] = v[x + i] = True
                    path.append("." * i + "Q" + "." * (n - i - 1))
                    dfs(x + 1)
                    path.pop()
                    col[i] = u[x - i + n - 1] = v[x + i] = False

        dfs(0)
        return res
