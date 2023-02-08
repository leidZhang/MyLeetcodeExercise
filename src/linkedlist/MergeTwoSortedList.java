package linkedlist;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {3,4};
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);

        assemble(head1, nums1);
        assemble(head2, nums2);
        // printLinkedList(head1);
        // printLinkedList(head2);

        ListNode head = mergeTwoLists(head1, head2);
        printLinkedList(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null || list2 != null) {
            int val1 = (list1 != null) ? list1.val : Integer.MAX_VALUE; // set to max value to avoid exception
            int val2 = (list2 != null) ? list2.val : Integer.MAX_VALUE;

            if (val1 < val2) {
                cur.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(val2);
                list2 = list2.next;
            }
            cur = cur.next;
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
