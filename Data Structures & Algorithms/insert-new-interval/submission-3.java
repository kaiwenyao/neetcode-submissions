class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {{newInterval[0], newInterval[1]}};
        }
        int i = 0;
        ArrayList<int[]> res = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        if (i == intervals.length) {
            res.add(new int[] {newInterval[0], newInterval[1]});
            return res.toArray(new int[0][]);
        }
        int st = Math.min(newInterval[0], intervals[i][0]);
        int ed = Math.max(newInterval[1], intervals[i][1]);
        if (newInterval[1] < intervals[i][0]) {
            st = newInterval[0];
            ed = newInterval[1];
        }

        while (i < intervals.length && ed >= intervals[i][0]) {
            ed = Math.max(ed, intervals[i][1]);
            i++;
        }
        res.add(new int[] {st, ed});

        while (i < intervals.length) {
            res.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
