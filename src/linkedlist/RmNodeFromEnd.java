package linkedlist;

public class RmNodeFromEnd {
    public static void main(String[] args) {
        int[] nums = {2};
        ListNode head = new ListNode(1);
        ListNode cur = head;

        for (int i : nums) {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }

        head = removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) { // modified on Feb 9th 2023
        ListNode dummy = new ListNode();
        dummy.next = head;
        // find the position
        int cnt = 0;
        ListNode slow = dummy; // slow pointer
        ListNode fast = dummy; // fast pointer
        while (fast != null) {
            if (cnt >= n+1) slow = slow.next; // slow pointer will stop at n+1th node from tail
            fast = fast.next;
            cnt++;
        }
        // delete operation
        ListNode cur = slow.next;
        ListNode next = cur.next;
        slow.next = next;

        return dummy.next;
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
