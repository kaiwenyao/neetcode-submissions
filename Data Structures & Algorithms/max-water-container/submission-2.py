class Solution:
    def maxArea(self, heights: List[int]) -> int:
        w = len(heights) - 1
        l = 0
        r = w
        res = 0
        while l < r:
            h = min(heights[l], heights[r])
            w = r - l
            cur = h * w
            res = max(res, cur)
            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1
            
        return res