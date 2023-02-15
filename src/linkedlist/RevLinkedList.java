package linkedlist;

public class RevLinkedList {
    /**
     * 1. get to 3
     * 2. connect 3 to 2
     * 3. 2 to null
     * 4. ...
     * Recursive demonstration:
     * 0 -> 1 -> 2 -> 3 -> null
     *            null
     *            /
     * 0 -> 1 -> 2    3
     *           \___/
     *       null
     *       /
     * 0 -> 1    2    3
     *      \___/\___/
     *  null
     *  /
     * 0    1    2    3
     * \___/\___/\___/
     * */
    public ListNode reverseListRec(ListNode head) {
        if (head == null) return null; // edge case
        if (head.next == null) return head; // base case

        ListNode newNode = reverseListRec(head.next);
        head.next.next = head; // form a local circular linked list
        head.next = null; // break the circle by pointing to null
        return newNode; // return reversed sub linked list
    }

    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null) return head; // edge cases

        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode next = cur.next;
        prev.next = null;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            // default constructor
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}
