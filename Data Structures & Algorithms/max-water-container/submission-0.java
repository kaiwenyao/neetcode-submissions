class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = -1;
        while (l < r) {
            int left = heights[l];
            int right = heights[r];
            int h = Math.min(left, right);
            res = Math.max(res, h * (r - l));
            if (left < right) {
                while (l < r && heights[l] <= left) {
                    l++;
                }
            } else {
                while (l < r && heights[r] <= right) {
                    r--;
                }
            }
        }
        return res;
    }
}
