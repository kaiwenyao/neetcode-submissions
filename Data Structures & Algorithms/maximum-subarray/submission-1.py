class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        res = None
        cur = 0

        for n in nums:
            if cur + n < n:
                cur = n
            else:
                cur += n
            res = cur if res is None else max(cur, res)
        return res