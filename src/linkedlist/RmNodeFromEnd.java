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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode prev = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count == 1 && n == 1) { // when only 1 element
            return null;
        }

        int idx = count - n;

        while (idx > 1) {
            prev = prev.next;
            idx--;
        }

        if (n != 1 && count != n) { // general cases
            ListNode next = prev.next.next;
            prev.next = next;
        } else if (n == 1) { // when delete tail node
            prev.next = null;
        } else { // when delete head node
            head = head.next;
        }

        return head;
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
