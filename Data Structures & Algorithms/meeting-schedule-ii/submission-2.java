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
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (Interval interval : intervals) {
            set.add(interval.start);
            set.add(interval.end);
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(set);
        int cnt = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            
            int cur = pq.poll();
            cnt += map.getOrDefault(cur, 0);
            max = Math.max(cnt, max);
        }
        return max;
    }
}
