class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1]
                || triplets[i][2] > target[2]) {
                continue;
            }
            tmp.add(triplets[i]);
        }
        if (tmp.size() == 0) {
            return false;
        }
        int a, b, c;
        a = 0;
        b = 0;
        c = 0;
        for (int[] arr : tmp) {
            a = Math.max(a, arr[0]);
            b = Math.max(b, arr[1]);
            c = Math.max(c, arr[2]);
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}
