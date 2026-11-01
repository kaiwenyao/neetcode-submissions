class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        r = 0
        l = 0
        cnt = defaultdict(int)
        dis = 0
        res = 0
        while r < len(s):
            cur = s[r]
            r += 1

            cnt[cur] += 1

            while l < r and sum(cnt.values()) - max(cnt.values()) > k:
                d = s[l]
                cnt[d] -= 1
                l += 1
            res = max(r - l, res)
        return res
