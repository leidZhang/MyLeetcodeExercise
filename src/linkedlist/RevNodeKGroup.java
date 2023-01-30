package linkedlist;

import linkedlist.MergeTwoSortedList;

public class RevNodeKGroup {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        ListNode head = new ListNode(1);
        int k = 5;

        assemble(head, nums);
        head = reverseKGroup(head, k);

        printLinkedList(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode front = head;
        ListNode rest = head;
        ListNode sentinel = new ListNode(0);
        ListNode frontNext = sentinel;

        while (true) {
            for (int i=0; i<k-1 && rest != null; i++) {
                rest = rest.next;
            }
            if (rest == null) break;
            rest = rest.next;

            ListNode swap = reverse(front, k); // swap this part
            frontNext.next = swap;
            frontNext = front;

            front.next = rest; // connect swapped part with rest
            front = rest; // move to the head of the rest part
        }

        return sentinel.next;
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode b = null;
        ListNode prev = head;
        ListNode next = head.next;
        prev.next = b;

        for (int i=1; i<k; i++) {
            b = prev;
            prev = next;
            next = next.next;

            prev.next = b;
        }

        return prev;
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");

        String res = "";
        while (head != null) {
            res += head.val + ",";
            head = head.next;
        }
        res = res.substring(0, res.lastIndexOf(","));

        System.out.print(res + "]\n");
    }

    public static void assemble(ListNode head, int[] nums) {
        ListNode cur = head;

        for (int i : nums) {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
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
