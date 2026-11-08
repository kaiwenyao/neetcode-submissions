from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        ind = [0] * numCourses
        # g = [[]] * numCourses
        g = [[] for _ in range(numCourses)]
        for v, u in prerequisites:
            ind[v] += 1
            g[u].append(v)
        
        q = deque()
        for i in range(numCourses):
            if ind[i] == 0:
                q.append(i)
        while q:
            cur = q.popleft()
            for nei in g[cur]:
                ind[nei] -= 1
                if ind[nei] == 0:
                    q.append(nei)
        return not any(n != 0 for n in ind)
            

            
