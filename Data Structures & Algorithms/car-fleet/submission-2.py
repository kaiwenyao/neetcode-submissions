class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), reverse=True)
        res = 0
        time = 0.0
        for p, s in cars:
            cur = (target - p) / s
            if cur > time:
                res += 1
                time = cur
        return res