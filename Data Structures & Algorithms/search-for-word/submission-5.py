class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        m = len(board)
        n = len(board[0])
        seen = set()

        def dfs(x, y, st: int):


            if st == len(word):
                return True
            if x < 0 or x >= m:
                return False
            if y < 0 or y >= n:
                return False
            if board[x][y] != word[st]:
                return False
            tmp = False
            for i in range(4):
                if (x + dx[i], y + dy[i]) in seen:
                    continue
                seen.add((x + dx[i], y + dy[i]))
                tmp = tmp or dfs(x + dx[i], y + dy[i], st + 1)
                seen.remove((x + dx[i], y + dy[i]))

            return tmp

        for i in range(m):
            for j in range(n):
                seen.add((i, j))
                if dfs(i, j, 0):
                    return True
                seen.remove((i, j))
        return False
