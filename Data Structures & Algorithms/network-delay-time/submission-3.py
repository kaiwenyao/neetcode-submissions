class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        INF = 0x3f3f3f3f
        dist = [INF] * (n + 1)
        dist[k] = 0
        g = [[] for _ in range(n + 1)]
        for e in times:
            g[e[0]].append((e[1], e[2]))
            
        st = [False] * (n + 1)
        for i in range(n):
            t = -1
            for j in range(1, n + 1):
                if not st[j] and (t == -1 or dist[j] < dist[t]):
                    t = j
            
            if t == -1 or dist[t] == INF:
                return -1
            st[t] = True
            for v, w in g[t]:
                if dist[v] > dist[t] + w:
                    dist[v] = dist[t] + w
        res = 0
        for i in range(1, n + 1):
            res = max(res, dist[i])
        return res