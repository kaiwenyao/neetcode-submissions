class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        s = set()
        for g in grid:
            for h in g:
                s.add(h)
        order: list = sorted(s)
        if len(order) == 1 and order[0] == 0:
            return 0
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        def bfs(level: int):
            
            if grid[0][0] > level:
                return -1
            q = deque()
            q.append((0, 0))
            st = set()
            st.add((0, 0))
            while q:
                cur = q.popleft()
                for i in range(4):
                    nx = dx[i] + cur[0]
                    ny = dy[i] + cur[1]
                    if 0 <= nx < n and 0 <= ny < n:
                        if (nx, ny) not in st and grid[nx][ny] <= level:
                            if nx == n - 1 and ny == n - 1:
                                return level
                            q.append((nx, ny))
                            st.add((nx, ny))
            return -1
        for t in order:
            res = bfs(t)
            if res != -1:
                return res

        return - 1
            
            
            

