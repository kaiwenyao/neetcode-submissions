class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        nums.sort()
        res = []
        i = 0
        n = len(nums)
        while i < len(nums):
            cur = nums[i]
            target = -cur
            l = i + 1
            r = len(nums) - 1
            path = []
            while l < r:
                left = nums[l]
                right = nums[r]
                s = left + right
                if s > target:
                    while l < r and nums[r] == right:
                        r -= 1
                elif s < target:
                    while l < r and nums[l] == left:
                        l += 1
                else:
                    path.append([cur, left, right])
                    while l < r and nums[r] == right:
                        r -= 1
                    while l < r and nums[l] == left:
                        l += 1

            if path:
                for p in path:
                    res.append(p)
            while i < len(nums) - 1 and nums[i] == nums[i + 1]:
                i += 1
            i += 1

        return res
