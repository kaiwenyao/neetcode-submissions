class CountSquares:

    def __init__(self):
        self.ps: list[tuple[int, int]] = []

    def add(self, point: List[int]) -> None:
        self.ps.append((point[0], point[1]))
        

    def count(self, point: List[int]) -> int:
        x = point[0]
        y = point[1]
        c = Counter(self.ps)
        candidates = [p[1] for p in self.ps if p[0] == x and p[1] != y]
        cnt = Counter(candidates)
        res = 0
        for y1 in cnt:
            edge = abs(y1 - y)
            p1 = (x + edge, y)
            p2 = (x + edge, y1)
            res += c[p1] * c[p2] * cnt[y1]
            p1 = (x - edge, y)
            p2 = (x - edge, y1)
            res += c[p1] * c[p2] * cnt[y1]
        return res

        
