class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        def dfs(x, y):
            grid[x][y] = "0"
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]):
                    if grid[nx][ny] == "1":
                        dfs(nx, ny)

        res = 0
        for m in range(len(grid)):
            for n in range(len(grid[m])):
                if grid[m][n] == "1":
                    res += 1
                    dfs(m, n)

        return res
