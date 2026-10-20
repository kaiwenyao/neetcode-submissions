class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        n = len(nums)
        total = sum(nums)
        if total & 1:
            return False
        target = total >> 1
        if max(nums) > target:
            return False
        f = [False] * (target + 1)
        f[0] = True
        # 定义：f[i] 表示，当前已经遍历过的元素，能否凑出i
        for x in nums:
            for j in range(target, x - 1, -1):
                if f[j - x]:
                    f[j] = True
        return f[target]
        