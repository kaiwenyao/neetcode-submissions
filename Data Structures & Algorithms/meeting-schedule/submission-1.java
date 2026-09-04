/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0 ) {
            return true;
        }
        int[][] tmp = new int[n][2];
        for (int i = 0; i < n; i ++ ) {
            Interval interval = intervals.get(i);
            tmp[i][0] = interval.start;
            tmp[i][1] = interval.end;
        }
        Arrays.sort(tmp, (a, b) -> {
            if (a[0] != b[0] ) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int ed = tmp[0][1];
        for (int i= 1; i <n ;i ++ ) {
            if (ed > tmp[i][0]) {
                return false;
            }
            ed = tmp[i][1];
        }
        return true;
    }
}
