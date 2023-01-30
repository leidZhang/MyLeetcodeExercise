package divide_and_conquer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    public static void main(String[] args) {
        int[] nums1 = {4, 5};
        int[] nums2 = {3, 4};
        int[] nums3 = {6};

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);

        assemble(head1, nums1);
        assemble(head2, nums2);
        assemble(head3, nums3);

        ListNode[] lists = {head1, head2, head3};
        ListNode head = mergeKLists(lists);

        printLinkedList(head);
    }

    static Comparator<ListNode> cmp = new Comparator<ListNode>() {
        public int compare(ListNode e1, ListNode e2) {
            return e1.val - e2.val; // e2 - e1 for desc
        }
    };

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(cmp);

        for (ListNode l : lists) {
            if (l != null) heap.add(l);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!heap.isEmpty()) {
            ListNode top = heap.peek();
            cur.next = top; // add at tail
            cur = cur.next; // move pointer forward

            heap.poll();
            if (top.next != null) heap.add(top.next); // add back if not null
        }

        return dummy.next;
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
