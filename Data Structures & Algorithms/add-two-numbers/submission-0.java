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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int c = 0;
        while (l1 != null && l2 != null) {
            if (c + l1.val + l2.val < 10) {
                p.next = new ListNode(l1.val + l2.val + c);
                c = 0;
            } else {
                p.next = new ListNode((c + l1.val + l2.val) % 10);
                c = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        while (l1 != null) {
            if (c + l1.val < 10) {
                p.next = new ListNode(l1.val + c);
                c = 0;
            }
            else {
                p.next = new ListNode((l1.val + c) % 10);
                c = 1;
            }
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            if (c + l2.val < 10) {
                p.next = new ListNode(l2.val + c);
                c = 0;
            }
            else {
                p.next = new ListNode((l2.val + c) % 10);
                c = 1;
            }
            l2 = l2.next;
            p = p.next;
        }
        if (c == 1) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
}
