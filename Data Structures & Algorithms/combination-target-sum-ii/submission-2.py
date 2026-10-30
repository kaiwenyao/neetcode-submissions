class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()

        res =[]
        path =[]
        def dfs(st: int, cur: int):
            if cur == target:
                res.append(path[:])
                return
            if cur > target:
                return
            
            for i in range(st, len(candidates)):
                if i > st and candidates[i] == candidates[i - 1]:
                    continue
                path.append(candidates[i])
                dfs(i + 1, cur + candidates[i])
                path.pop()

        dfs(0, 0)
        return res
                

