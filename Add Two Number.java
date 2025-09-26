/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     *
     * @param l1 The first linked list.
     * @param l2 The second linked list.
     * @return The sum as a linked list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head to simplify handling the start of the result list.
        ListNode dummyHead = new ListNode(0);
        // 'current' will be used to build the new list.
        ListNode current = dummyHead;
        int carry = 0;

        // Loop as long as there are digits in either list or there is a carry.
        while (l1 != null || l2 != null || carry != 0) {
            // Get the value of the current nodes. If a list is shorter, its value is 0.
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum of digits and the carry.
            int sum = carry + x + y;
            carry = sum / 10; // The new carry is the tens digit.
            
            // Create a new node with the ones digit of the sum.
            current.next = new ListNode(sum % 10);
            // Move the 'current' pointer to the new node.
            current = current.next;

            // Move to the next nodes in the input lists if they exist.
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // The result list starts after the dummy head.
        return dummyHead.next;
    }
}
