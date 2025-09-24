package com.leetcode.trees;

import com.leetcode.utils.TreeNode;

/**
 * LeetCode Problem 104: Maximum Depth of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree (recursion stack)
 */

public class MaximumDepthOfBinaryTree {
    
    /**
     * Approach 1: Recursive DFS (Depth-First Search)
     * 
     * The depth of a tree is 1 + maximum depth of its subtrees.
     * Base case: null node has depth 0.
     * 
     * @param root Root of the binary tree
     * @return Maximum depth of the tree
     */
    public int maxDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }
        
        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Current node adds 1 to the maximum depth of subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    /**
     * Approach 2: Iterative BFS (Breadth-First Search) using Queue
     * 
     * We traverse the tree level by level and count the levels.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(w) where w is the maximum width of the tree
     */
    public int maxDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++; // We're about to process a new level
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                // Add children to queue for next level
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        
        return depth;
    }
    
    /**
     * Approach 3: Iterative DFS using Stack
     * 
     * We use a stack to simulate the recursive calls.
     * Each stack element contains a node and its current depth.
     */
    public int maxDepthIterativeDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        java.util.Stack<TreeNodeWithDepth> stack = new java.util.Stack<>();
        stack.push(new TreeNodeWithDepth(root, 1));
        int maxDepth = 0;
        
        while (!stack.isEmpty()) {
            TreeNodeWithDepth current = stack.pop();
            TreeNode node = current.node;
            int depth = current.depth;
            
            maxDepth = Math.max(maxDepth, depth);
            
            if (node.left != null) {
                stack.push(new TreeNodeWithDepth(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new TreeNodeWithDepth(node.right, depth + 1));
            }
        }
        
        return maxDepth;
    }
    
    /**
     * Helper class for iterative DFS approach
     */
    private static class TreeNodeWithDepth {
        TreeNode node;
        int depth;
        
        TreeNodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}