package com.leetcode.strings;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ValidAnagram solution
 */
public class ValidAnagramTest {
    
    private ValidAnagram solution;
    
    @BeforeEach
    void setUp() {
        solution = new ValidAnagram();
    }
    
    @Test
    void testIsAnagram_basicExample() {
        String s = "anagram";
        String t = "nagaram";
        
        assertTrue(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_notAnagram() {
        String s = "rat";
        String t = "car";
        
        assertFalse(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_differentLengths() {
        String s = "abc";
        String t = "abcd";
        
        assertFalse(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_emptyStrings() {
        String s = "";
        String t = "";
        
        assertTrue(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_singleCharacter() {
        String s = "a";
        String t = "a";
        
        assertTrue(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_singleCharacterDifferent() {
        String s = "a";
        String t = "b";
        
        assertFalse(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_repeatedCharacters() {
        String s = "aab";
        String t = "baa";
        
        assertTrue(solution.isAnagram(s, t));
    }
    
    @Test
    void testIsAnagram_repeatedCharactersDifferentCount() {
        String s = "aab";
        String t = "abb";
        
        assertFalse(solution.isAnagram(s, t));
    }
    
    // Test alternative approaches for consistency
    @Test
    void testAllApproaches_consistency() {
        String s = "listen";
        String t = "silent";
        
        boolean result1 = solution.isAnagram(s, t);
        boolean result2 = solution.isAnagramSorting(s, t);
        boolean result3 = solution.isAnagramHashMap(s, t);
        boolean result4 = solution.isAnagramTwoMaps(s, t);
        
        // All approaches should give same result
        assertEquals(result1, result2);
        assertEquals(result1, result3);
        assertEquals(result1, result4);
        
        // And they should all be true for this anagram
        assertTrue(result1);
    }
    
    @Test
    void testAllApproaches_notAnagram() {
        String s = "hello";
        String t = "world";
        
        boolean result1 = solution.isAnagram(s, t);
        boolean result2 = solution.isAnagramSorting(s, t);
        boolean result3 = solution.isAnagramHashMap(s, t);
        boolean result4 = solution.isAnagramTwoMaps(s, t);
        
        // All approaches should give same result
        assertEquals(result1, result2);
        assertEquals(result1, result3);  
        assertEquals(result1, result4);
        
        // And they should all be false for this non-anagram
        assertFalse(result1);
    }
    
    @Test
    void testSortingApproach_edgeCases() {
        // Test empty strings
        assertTrue(solution.isAnagramSorting("", ""));
        
        // Test same string
        assertTrue(solution.isAnagramSorting("test", "test"));
        
        // Test different lengths
        assertFalse(solution.isAnagramSorting("short", "longer"));
    }
    
    @Test
    void testHashMapApproach_edgeCases() {
        // Test empty strings
        assertTrue(solution.isAnagramHashMap("", ""));
        
        // Test same string
        assertTrue(solution.isAnagramHashMap("identical", "identical"));
        
        // Test case sensitivity (assuming lowercase input)
        assertTrue(solution.isAnagramHashMap("abc", "bca"));
    }
}