# Linked Lists - LeetCode Problems

This directory contains solutions to linked list problems. Linked lists are crucial for understanding pointer manipulation, recursion, and memory management concepts.

## 📝 Problems Solved

### Easy Level
- **[Problem 206: Reverse Linked List](ReverseLinkedList.java)** - Both iterative and recursive approaches

### Medium Level
- *Coming soon...*

### Hard Level
- *Coming soon...*

## 🎯 Key Concepts Covered

- **Pointer Manipulation**: Working with next pointers
- **Two Pointers**: Fast and slow pointer technique
- **Recursion**: Recursive solutions for list operations
- **Dummy Nodes**: Simplifying edge cases
- **Cycle Detection**: Floyd's algorithm
- **List Merging**: Combining sorted lists

## 📊 Complexity Analysis Summary

| Problem | Time Complexity | Space Complexity | Approach |
|---------|----------------|------------------|----------|
| Reverse Linked List (Iterative) | O(n) | O(1) | Three Pointers |
| Reverse Linked List (Recursive) | O(n) | O(n) | Recursion Stack |

## 🔗 Useful Patterns

1. **Reversal Pattern**: Three pointer technique (prev, current, next)
2. **Two Pointer Pattern**: Fast/slow for cycle detection and middle finding
3. **Dummy Node Pattern**: Simplifies insertion and deletion
4. **Recursion Pattern**: Process rest first, then current

## 🛠️ Utility Classes

- **[ListNode](../utils/ListNode.java)**: Complete implementation with helper methods
  - Array to list conversion
  - List to array conversion
  - Pretty printing for debugging

## 📚 Next Steps

Focus on these common linked list patterns:
- Merge two sorted lists
- Detect and remove cycles
- Find intersection point
- Remove nth node from end
- Copy list with random pointers