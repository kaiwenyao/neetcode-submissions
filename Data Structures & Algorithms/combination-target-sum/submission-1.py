class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        sum = 0
        res = []
        path = []
        def dfs(st: int):
            nonlocal sum
            if sum == target:
                res.append(list(path))
                return
            if sum > target:
                return
            for i in range(st, len(nums)):
                path.append(nums[i])
                sum += nums[i]
                dfs(i)
                path.pop()
                sum -= nums[i]

        dfs(0)
        return res