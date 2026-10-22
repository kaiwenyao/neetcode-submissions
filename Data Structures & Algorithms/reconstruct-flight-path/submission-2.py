class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:

        g: dict[str, list[str]] = defaultdict(list)
        for u, v in sorted(tickets, reverse=True):
            g[u].append(v)

        res = []

        def dfs(node: str):
            while g[node]:
                dfs(g[node].pop())
            res.append(node)
        dfs("JFK")
        return res[::-1]
