package linkedlist;

public class RmLinkedList {
    public static void main(String[] args) {
        int[] nums1 = {2,6,3,4,5,6};
        ListNode head1 = new ListNode(1);

        assemble(head1, nums1);
        // printLinkedList(head1);
        // printLinkedList(head2);

        ListNode head = removeElements(head1, 6);
        printLinkedList(head);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        while (pre != null) {
            ListNode cur = pre.next;
            if (cur != null && cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
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
