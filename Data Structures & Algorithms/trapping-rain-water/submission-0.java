class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] = max;
            max = Math.max(height[i], max);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(height[i], max);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int h = Math.min(left[i], right[i]);
            if (height[i] > h) {
                continue;
            }
            sum += h - height[i];
        }
        return sum;
    }
}
