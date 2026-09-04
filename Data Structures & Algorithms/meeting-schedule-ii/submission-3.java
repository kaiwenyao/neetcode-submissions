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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] st = new int[n];
        int[] ed = new int[n];
        for (int i = 0; i < n ;i ++ ) {
            st[i] = intervals.get(i).start;
            ed[i] = intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(ed);
        int i = 0, j =0, cnt = 0, max= 0;
        while (i < n && j < n) {
            if (st[i] < ed[j] ) {
                cnt ++;
                i ++;
            }
            else {
                cnt --;
                j ++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
