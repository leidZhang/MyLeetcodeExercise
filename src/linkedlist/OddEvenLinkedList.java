package linkedlist;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8};
        ListNode head = new ListNode(1);
        assemble(head, nums);
        head = oddEvenList2(head);
        printLinkedList(head);
    }

    public static ListNode oddEvenList2(ListNode head) {
        if (head == null) return null; // edge case

        ListNode dummy1 = new ListNode(0, head);
        ListNode dummy2 = new ListNode(0);
        ListNode odd = head;
        ListNode even = dummy2;

        while (odd.next != null) {
            even.next = odd.next;
            odd.next = odd.next.next;
            if (odd.next != null) odd = odd.next; // case even number nodes
            even = even.next;
        }

        even.next = null;
        odd.next = dummy2.next;

        return dummy1.next;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode evens = new ListNode();
        ListNode odds = new ListNode();
        ListNode mid = evens;
        ListNode front = odds;

        int cnt = 1;
        while (head != null) {
            int val = head.val;

            if (cnt % 2 == 0) {
                ListNode newNode = new ListNode(val);
                evens.next = newNode;
                evens = evens.next;
            } else {
                ListNode newNode = new ListNode(val);
                odds.next = newNode;
                odds = odds.next;
            }

            head = head.next;
            cnt++;
        }
        odds.next = mid.next;

        return front.next;
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
