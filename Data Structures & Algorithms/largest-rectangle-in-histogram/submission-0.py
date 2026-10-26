class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:

        heights.append(0)
        stk = []
        res = 0
        for i, h in enumerate(heights):
            while stk and h < heights[stk[-1]]:
                pre = stk.pop()
                area = heights[pre] * (i - stk[-1] - 1) if stk else heights[pre] * i
                res = max(area, res)
            stk.append(i)
        
        return res
        


