package com.leetcode.utils;

/**
 * Definition for singly-linked list node.
 * This is a common data structure used in many LeetCode linked list problems.
 */
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    
    public ListNode(int val) {
        this.val = val;
    }
    
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    /**
     * Creates a linked list from an array of values.
     * @param values Array of integer values
     * @return Head of the created linked list
     */
    public static ListNode createFromArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * Converts linked list to array for easy testing and visualization.
     * @param head Head of the linked list
     * @return Array representation of the linked list
     */
    public static int[] toArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        
        // First pass: count nodes
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        
        // Second pass: populate array
        int[] result = new int[count];
        current = head;
        for (int i = 0; i < count; i++) {
            result[i] = current.val;
            current = current.next;
        }
        
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        sb.append("[");
        
        while (current != null) {
            sb.append(current.val);
            current = current.next;
            if (current != null) {
                sb.append(" -> ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
}