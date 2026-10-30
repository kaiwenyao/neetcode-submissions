class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        nums.sort()
        res = []
        path = []
        def dfs(st: int):
            res.append(path[:])

            for i in range(st, len(nums)):
                if i > st and nums[i] == nums[i - 1]:
                    continue
                path.append(nums[i])
                dfs(i + 1)
                path.pop()
        dfs(0)
        return res
            

