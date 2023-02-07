package linkedlist;

public class AddTwoNums {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) { // updated on Feb 6th, 2023
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0; // init carry
        // merge nodes
        while (l1 != null || l2 != null) {
            int num1 = 0; // init num1
            int num2 = 0; // init num2
            if (l1 != null) num1 = l1.val;
            if (l2 != null) num2 = l2.val;

            ListNode newNode = new ListNode((num1 + num2 + carry) % 10); // store digit to the new node
            carry = (num1 + num2 + carry) / 10; // cal carry
            temp.next = newNode; // set next
            temp = temp.next; // to next node

            if (l1 != null) l1 = l1.next; // traverse until l1 is empty
            if (l2 != null) l2 = l2.next; // traverse until l2 is empty
        }
        // in case carry != 0
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(2, new ListNode(9, new ListNode(3, new ListNode(1, new ListNode(1))))))))));
        ListNode l2 = new ListNode(0, new ListNode(9, new ListNode(1, new ListNode(5, new ListNode(5, new ListNode(5, new ListNode(1, new ListNode(1, new ListNode(6)))))))));
        ListNode l3 = addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.print(l3.val);
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
