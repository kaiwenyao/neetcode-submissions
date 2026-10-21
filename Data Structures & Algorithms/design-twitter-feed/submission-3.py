from heapq import heappush, heappop
class Twitter:

    def __init__(self):
        self.cnt: int = 1
        self.pq: list[tuple[int, int, int]] = []
        # 优先级，userId和tweetid
        self.fl: dict[int, set[int]] = {}


        

    def postTweet(self, userId: int, tweetId: int) -> None:
        t = (-self.cnt, userId, tweetId)
        heappush(self.pq, t)
        self.cnt += 1
        

    def getNewsFeed(self, userId: int) -> List[int]:
        tmp = []
        res = []
        newsCnt = 0
        while len(self.pq) > 0 and newsCnt < 10:
            cur = heappop(self.pq)
            if cur[1] in self.fl.get(userId, ()) or cur[1] == userId:
                res.append(cur[2])
                newsCnt += 1
            tmp.append(cur)
        for t in tmp:
            heappush(self.pq, t)
        return res

        

    def follow(self, followerId: int, followeeId: int) -> None:
        self.fl.setdefault(followerId, set()).add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        fls = self.fl.get(followerId)
        if fls is None:
            return
        fls.discard(followeeId)

