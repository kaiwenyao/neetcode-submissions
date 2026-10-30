class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        q = deque()
        
        cnt = 0
        seen = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append((i, j))
                    seen.add((i, j))
                elif grid[i][j] == 1:
                    cnt += 1
        if cnt == 0:
            return 0

        time = 0
        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        while q:
            time += 1
            si = len(q)
            for i in range(si):
                x, y = q.popleft()
                for j in range(4):
                    nx = x + dx[j]
                    ny = y + dy[j]
                    if 0 <= nx < len(grid) and 0 <= ny < len(grid[0]) and grid[nx][ny] == 1 and (nx, ny) not in seen:
                        seen.add((nx, ny))
                        q.append((nx, ny))
                        cnt -= 1
                        grid[nx][ny] = 2
            
        return time -1 if cnt == 0 else -1
