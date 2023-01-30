package linkedlist;

public class AddTwoNums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        boolean flag = false;

        if (l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null) {
            return l1;
        }

        while (l1 != null || l2 != null) {
            int cur1 = 0;
            int cur2 = 0;

            if (l1 != null) {
                cur1 = l1.val;
                l1 = l1.next;
            } else {
                cur1 = 0;
            }

            if (l2 != null) {
                cur2 = l2.val;
                l2 = l2.next;
            } else {
                cur2 = 0;
            }

            int cur = cur1 + cur2;


            if (flag) {
                cur += 1;
                flag = false;
            }

            if (cur >= 10) {
                cur -= 10;
                flag = true;
            }

            ListNode newNode = new ListNode(cur);
            tail.next = newNode;
            tail = newNode;
        }

        if (flag) {
            ListNode newNode = new ListNode(1);
            tail.next = newNode;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(2, new ListNode(9, new ListNode(3, new ListNode(1, new ListNode(1))))))))));
        ListNode l2 = new ListNode(0, new ListNode(9, new ListNode(1, new ListNode(5, new ListNode(5, new ListNode(5, new ListNode(1, new ListNode(1, new ListNode(6)))))))));
        ListNode l3 = addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val + " ");
            l3 = l3.next;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

}
