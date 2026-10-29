class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        cnt = Counter(hand)
        for x in sorted(cnt):
            while cnt[x] > 0:
                for y in range(groupSize):
                    cnt[x + y] -= 1
                    if cnt[x + y] < 0:
                        return False
        return True
