package linkedlist;

public class SwapNodePairs {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 6};
        ListNode head = new ListNode(1);
        assemble(head, nums);
        head = swapPairs(head);
        printLinkedList(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode sentinel = new ListNode(0, head); // sentinel node
        ListNode left = head;
        ListNode right = head.next;
        ListNode cur = sentinel;
        head = sentinel;

        while (right != null && left != null) {
            cur.next = right;
            left.next = right.next;
            right.next = left;

            cur = left;
            if (cur.next == null) break; else left = cur.next;
            if (left.next == null) break; else right = left.next;
        }

        return head.next;
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
