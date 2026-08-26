/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> { return a.val - b.val; });
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (ListNode list : lists) {
            if (list == null ) {
                continue;
            }
            pq.offer(list);
        }
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            if (poll.next != null) {
                pq.offer(poll.next);
            }
            p.next = poll;
            p = p.next;
            p.next = null;
        }
        return dummy.next;
    }
}
