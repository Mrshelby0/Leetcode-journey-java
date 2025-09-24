package com.leetcode.linkedlists;

import com.leetcode.utils.ListNode;

/**
 * LeetCode Problem 206: Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) for iterative, O(n) for recursive
 */

public class ReverseLinkedList {
    
    /**
     * Approach 1: Iterative Solution
     * 
     * We use three pointers: prev, current, and next.
     * We reverse the links one by one by making current.next point to prev.
     * 
     * @param head Head of the original linked list
     * @return Head of the reversed linked list
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            // Store next node before changing the link
            ListNode nextNode = current.next;
            
            // Reverse the link
            current.next = prev;
            
            // Move pointers forward
            prev = current;
            current = nextNode;
        }
        
        // prev is now the new head of the reversed list
        return prev;
    }
    
    /**
     * Approach 2: Recursive Solution
     * 
     * The recursive approach reverses the rest of the list first,
     * then reverses the current connection.
     * 
     * @param head Head of the original linked list
     * @return Head of the reversed linked list
     */
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        ListNode reversedHead = reverseListRecursive(head.next);
        
        // Reverse the current connection
        // head.next is now the last node of the reversed part
        head.next.next = head;
        head.next = null;
        
        return reversedHead;
    }
    
    /**
     * Helper method to demonstrate usage
     */
    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        
        // Create test list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("Original: " + head);
        
        // Test iterative solution
        ListNode reversed1 = solution.reverseListIterative(head);
        System.out.println("Reversed (Iterative): " + reversed1);
        
        // Test recursive solution (reverse back to original)
        ListNode reversed2 = solution.reverseListRecursive(reversed1);
        System.out.println("Reversed back (Recursive): " + reversed2);
    }
}