package linkedlist;

public class RmSortedDuplicateNode {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;

        while (pre != null && pre.next != null) {
            ListNode cur = pre.next;
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }

    public class ListNode {
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
