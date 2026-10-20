class Solution:
    
        
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        p = [-1] * (n + 1)
        for i in range(len(p)):
            p[i] = i
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        for a, b in edges: 
            rootA = find(a)
            rootB = find(b)
            if rootA == rootB:
                return [a, b]
            p[rootA] = rootB
        return [-1, -1]
        

            
