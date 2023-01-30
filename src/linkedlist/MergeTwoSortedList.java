package linkedlist;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {};
        ListNode head1 = null;
        ListNode head2 = null;

        assemble(head1, nums1);
        assemble(head2, nums2);
        // printLinkedList(head1);
        // printLinkedList(head2);

        ListNode head = mergeTwoLists(head1, head2);
        printLinkedList(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode cur = null;

        while (list1 != null || list2 != null) {
            int val;

            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    val = list1.val;
                    list1 = list1.next;
                } else {
                    val = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                val = list2.val;
                list2 = list2.next;
            } else {
                val = list1.val;
                list1 = list1.next;
            }

            if (head == null) {
                head = new ListNode(val);
                cur = head;
                continue;
            }

            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;
        }

        return head;
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
