class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int c1 = 0;
        int c2 = m - 1;
        int r1 = 0;
        int r2 = n - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (c1 <= c2 && r1 <= r2) {
            for (int i = c1; i <= c2; i ++) {
                res.add(matrix[r1][i]);
            }
            r1 ++;
            for (int i = r1; i <= r2; i ++) {
                res.add(matrix[i][c2]);
            }
            c2 --;
            if (r1 <= r2)
            for (int i = c2; i >= c1; i -- ) {
                res.add(matrix[r2][i]);
            }
            r2 --;
            if (c1 <= c2)
            for (int i = r2; i >= r1; i --) {
                res.add(matrix[i][c1]);
            }
            c1 ++;
        }
        return res;
    }
}
