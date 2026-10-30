class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        st = set()

        res = []
        path = []
        def dfs():
            if len(path) == len(nums):
                res.append(path[:])
                return
            for n in nums:
                if n not in st:
                    path.append(n)
                    st.add(n)
                    dfs()
                    path.pop()
                    st.remove(n)
        dfs()
        return res


