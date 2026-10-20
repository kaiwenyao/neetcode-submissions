class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        if sum(nums) % 2 == 1:
            return False
        target = sum(nums) // 2
        f = [0] * (target + 1)
        for i in range(n):
            for j in range(target, nums[i] - 1, -1):
                f[j] = max(f[j], f[j - nums[i]] + nums[i])
        return f[target] == target

