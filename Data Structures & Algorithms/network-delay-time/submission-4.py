from heapq import heappush, heappop

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        INF = 0x3f3f3f3f
        dist = [INF] * (n + 1)
        dist[k] = 0

        g = [[] for _ in range(n + 1)]
        for u, v, w in times:
            g[u].append((v, w))

        pq = []
        
        heappush(pq, (0, k))
        while len(pq) != 0:
            d, u = heappop(pq)
            if dist[u] < d:
                continue
            for v, w in g[u]:
                if dist[v] > dist[u] + w:
                    dist[v] = dist[u] + w
                    heappush(pq, (dist[v], v))

                
        ans = max(dist[1:])
        return -1 if ans == INF else ans
            
