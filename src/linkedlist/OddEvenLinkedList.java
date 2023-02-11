package linkedlist;

public class OddEvenLinkedList {
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
