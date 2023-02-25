package linkedlist;

public class RmDuplicateListNode_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        ListNode head = new ListNode(1);

        assemble(head, nums);
        head = deleteDuplicates(head);

        printLinkedList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.next != null && next.val == next.next.val) {
                next = next.next;
            }
            if (cur.next == next) cur = cur.next;
            else cur.next = next.next;
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode next = cur.next;

        while (next != null) {
            if (cur.val == next.val) {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = next;
                if (cur == null) break;
                next = next.next;
            } else {
                cur = cur.next;
                next = next.next;
                pre = pre.next;
            }
        }

        return dummy.next;
    }

    public static void assemble(ListNode head, int[] nums) {
        ListNode cur = head;

        for (int i : nums) {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
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
