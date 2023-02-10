package linkedlist;

public class LinkedListCycle_II {
    /**
     * dist(slow) = x + y
     * dist(fast) = x + y + n * (y + z), n >= 1
     * 2 * (x + y) = x + y + n * (y + z)
     * x + y = n * (y + z)
     * x = (n - 1) * (y + z) + z
     * if n = 1, x = z
     * */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode idx1 = fast;
                ListNode idx2 = head;

                while (idx1 != idx2) {
                    idx1 = idx1.next;
                    idx2 = idx2.next;
                }
                return idx2;
            }
        }

        return null;
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
