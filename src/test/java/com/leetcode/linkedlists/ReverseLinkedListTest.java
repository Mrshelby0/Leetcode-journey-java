package com.leetcode.linkedlists;

import com.leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ReverseLinkedList solution
 */
public class ReverseLinkedListTest {
    
    private ReverseLinkedList solution;
    
    @BeforeEach
    void setUp() {
        solution = new ReverseLinkedList();
    }
    
    @Test
    void testReverseList_basicExample() {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        
        // Reverse it
        ListNode reversed = solution.reverseListIterative(head);
        
        // Check result: should be 5 -> 4 -> 3 -> 2 -> 1
        int[] expected = {5, 4, 3, 2, 1};
        int[] actual = ListNode.toArray(reversed);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void testReverseList_singleNode() {
        ListNode head = ListNode.createFromArray(new int[]{1});
        
        ListNode reversed = solution.reverseListIterative(head);
        
        int[] expected = {1};
        int[] actual = ListNode.toArray(reversed);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void testReverseList_emptyList() {
        ListNode head = null;
        
        ListNode reversed = solution.reverseListIterative(head);
        
        assertNull(reversed);
    }
    
    @Test
    void testReverseList_twoNodes() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2});
        
        ListNode reversed = solution.reverseListIterative(head);
        
        int[] expected = {2, 1};
        int[] actual = ListNode.toArray(reversed);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void testReverseListRecursive_basicExample() {
        ListNode head = ListNode.createFromArray(new int[]{1, 2, 3, 4, 5});
        
        ListNode reversed = solution.reverseListRecursive(head);
        
        int[] expected = {5, 4, 3, 2, 1};
        int[] actual = ListNode.toArray(reversed);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void testReverseListRecursive_emptyList() {
        ListNode head = null;
        
        ListNode reversed = solution.reverseListRecursive(head);
        
        assertNull(reversed);
    }
    
    @Test
    void testReverseListRecursive_singleNode() {
        ListNode head = ListNode.createFromArray(new int[]{42});
        
        ListNode reversed = solution.reverseListRecursive(head);
        
        int[] expected = {42};
        int[] actual = ListNode.toArray(reversed);
        
        assertArrayEquals(expected, actual);
    }
    
    @Test
    void testBothMethods_consistency() {
        // Test that both iterative and recursive methods produce the same result
        int[] originalValues = {10, 20, 30, 40};
        
        ListNode head1 = ListNode.createFromArray(originalValues);
        ListNode head2 = ListNode.createFromArray(originalValues);
        
        ListNode reversed1 = solution.reverseListIterative(head1);
        ListNode reversed2 = solution.reverseListRecursive(head2);
        
        int[] result1 = ListNode.toArray(reversed1);
        int[] result2 = ListNode.toArray(reversed2);
        
        assertArrayEquals(result1, result2);
        
        int[] expected = {40, 30, 20, 10};
        assertArrayEquals(expected, result1);
    }
}