class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int st = intervals[0][0];
        int ed = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int a = interval[0];
            int b = interval[1];
            if (ed >= a) {
                ed = Math.max(ed, b);
            } else {
                list.add(new int[] {st, ed});
                st = a;
                ed = b;
            }
        }
        list.add(new int[] {st, ed});
        return list.toArray(new int[0][]);
    }
}
