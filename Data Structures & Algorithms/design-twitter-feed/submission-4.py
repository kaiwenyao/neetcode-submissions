from heapq import heappush, heappop


class Twitter:

    def __init__(self):
        self.tick = 0                                       # 全局时间戳，越大越新
        self.tweets: dict[int, list[tuple[int, int]]] = {}  # userId -> [(tick, tweetId)]
        self.fl: dict[int, set[int]] = {}                   # userId -> {followeeId}

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tick += 1
        self.tweets.setdefault(userId, []).append((self.tick, tweetId))

    def getNewsFeed(self, userId: int) -> list[int]:
        users = self.fl.get(userId, set()) | {userId}       # 关注的人 + 自己
        heap: list[tuple[int, int]] = []                    # 只保留最近 10 条
        for u in users:
            lst = self.tweets.get(u)
            if not lst:
                continue
            for entry in lst[-10:]:                         # 每人最多贡献 10 条
                heappush(heap, entry)
                if len(heap) > 10:
                    heappop(heap)                           # 弹掉最旧的，堆恒定 ≤ 10

        res: list[int] = []
        while heap:
            res.append(heappop(heap)[1])                    # 时间戳升序弹出
        res.reverse()                                       # 反转 → 最新的在前
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        self.fl.setdefault(followerId, set()).add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        s = self.fl.get(followerId)
        if s is not None:
            s.discard(followeeId)