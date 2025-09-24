package com.leetcode.strings;

/**
 * LeetCode Problem 242: Valid Anagram
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Example:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) for character counting (constant size), O(n log n) for sorting approach
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    
    /**
     * Approach 1: Character Frequency Counting (Most Efficient)
     * 
     * Count the frequency of each character in both strings.
     * If frequencies match, the strings are anagrams.
     * 
     * @param s First string
     * @param t Second string
     * @return true if t is an anagram of s
     */
    public boolean isAnagram(String s, String t) {
        // Quick check: different lengths can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        // Array to count character frequencies (assuming lowercase English letters)
        int[] charCount = new int[26];
        
        // Count characters in both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment for first string
            charCount[t.charAt(i) - 'a']--; // Decrement for second string
        }
        
        // If strings are anagrams, all counts should be zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Approach 2: Sorting (Alternative approach)
     * 
     * Sort both strings and compare. If they're equal after sorting,
     * they contain the same characters and are anagrams.
     * 
     * Time Complexity: O(n log n) due to sorting
     * Space Complexity: O(n) for character arrays
     */
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert to character arrays and sort
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Compare sorted arrays
        return Arrays.equals(sChars, tChars);
    }
    
    /**
     * Approach 3: Hash Map (More flexible for Unicode characters)
     * 
     * Use a hash map to count character frequencies.
     * This approach works for any character set, not just lowercase English.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     */
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in first string
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Decrement count for characters in second string
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false; // Character not in first string
            }
            
            int count = charCount.get(c) - 1;
            if (count == 0) {
                charCount.remove(c);
            } else {
                charCount.put(c, count);
            }
        }
        
        // Map should be empty if strings are anagrams
        return charCount.isEmpty();
    }
    
    /**
     * Approach 4: Two separate frequency maps (for educational purposes)
     * 
     * Create frequency maps for both strings and compare them.
     */
    public boolean isAnagramTwoMaps(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        
        // Build frequency maps
        for (char c : s.toCharArray()) {
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        // Compare maps
        return sCount.equals(tCount);
    }
    
    /**
     * Demo method to show different approaches
     */
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        
        String s1 = "anagram";
        String t1 = "nagaram";
        
        String s2 = "rat";
        String t2 = "car";
        
        System.out.println("Testing: \"" + s1 + "\" and \"" + t1 + "\"");
        System.out.println("Frequency counting: " + solution.isAnagram(s1, t1));
        System.out.println("Sorting approach: " + solution.isAnagramSorting(s1, t1));
        System.out.println("HashMap approach: " + solution.isAnagramHashMap(s1, t1));
        
        System.out.println("\nTesting: \"" + s2 + "\" and \"" + t2 + "\"");
        System.out.println("Frequency counting: " + solution.isAnagram(s2, t2));
        System.out.println("Sorting approach: " + solution.isAnagramSorting(s2, t2));
        System.out.println("HashMap approach: " + solution.isAnagramHashMap(s2, t2));
    }
}