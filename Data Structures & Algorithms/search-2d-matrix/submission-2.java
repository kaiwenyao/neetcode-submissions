class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[mid / n][mid % n] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return matrix[l / n][l % n] == target;
    }
}
