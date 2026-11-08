import heapq, math
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        # create max heap
        pq = []
        for x, y in points:
            dist = math.sqrt(x * x + y * y)
            heapq.heappush(pq, (-dist, x, y))
            if len(pq) > k:
                heapq.heappop(pq)
        res = []
        for i, x, y in pq:
            res.append([x, y])
        return res
        
        