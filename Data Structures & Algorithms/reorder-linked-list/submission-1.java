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
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> stk = new ArrayDeque<>();
        ListNode p = head;
        while (p != null) {
            stk.push(p);
            p = p.next;
        }
        p = head;

        while (true) {
            ListNode pop = stk.pop();
            ListNode tmp = p.next;
            if (pop == tmp || pop.next == tmp) {
                pop.next = null;
                return ;
            }
            pop.next = tmp;
            p.next = pop;
            p = tmp;
        }
    }
}
