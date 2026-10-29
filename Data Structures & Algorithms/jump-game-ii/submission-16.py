class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        cover = 0
        cur = 0
        res = 0

        for i, n in enumerate(nums):
            cover = max(cover, i + n)
            if i == cur:
                res += 1
                cur = cover
                if cur >= len(nums) - 1:
                    break
        return res

