class Solution:
    def canJump(self, nums: List[int]) -> bool:
        cover = 0

        for i, n in enumerate(nums):
            if cover < i:
                return False
            cover = max(cover, i + n)
        return True


