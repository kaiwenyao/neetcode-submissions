/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node p = dummy;
        Node po = head;
        Map<Node, Node> map = new HashMap<>();
        while (po != null) {
            p.next = new Node(po.val);
            map.put(po, p.next);
            p = p.next;
            po = po.next;
        }
        p = dummy;
        po = head;
        while (po != null ) {
            p.next.random = map.get(po.random);
            p = p.next;
            po = po.next;
        }

        return dummy.next;

    }
}
