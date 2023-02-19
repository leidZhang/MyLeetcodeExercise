package linkedlist;

public class ConvertBinary {
    public int getDecimalValue(ListNode head) {
        int res = 0, i = 0;

        head = reverseListRec(head);
        while (head != null) {
            res += head.val * Math.pow(2, i);
            head = head.next;
            i++;
        }

        return res;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null) return null; // edge case
        if (head.next == null) return head; // base case

        ListNode newNode = reverseListRec(head.next);
        head.next.next = head; // form a local circular linked list
        head.next = null; // break the circle by pointing to null
        return newNode; // return reversed sub linked list
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
