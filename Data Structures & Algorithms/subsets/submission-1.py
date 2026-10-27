class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:

        res = []
        path = []
        def dfs(st: int):
            res.append(list(path))

            for i in range(st, len(nums)):
                path.append(nums[i])
                dfs(i + 1)
                path.pop()

        dfs(0)
        return res


