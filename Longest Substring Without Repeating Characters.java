import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // This map stores the most recent index of each character found.
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // The starting index of the current non-repeating substring.

        // 'end' is the right pointer of the sliding window.
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the current character is already in the map and its index is within
            // the current window (i.e., >= start), we must move the start of the window.
            if (map.containsKey(currentChar)) {
                // Move the start to the position right after the last occurrence of currentChar.
                // We take the max with the current 'start' to avoid moving the window backward.
                start = Math.max(start, map.get(currentChar) + 1);
            }

            // Update the last seen index of the current character.
            map.put(currentChar, end);

            // Calculate the length of the current window and update maxLength if it's greater.
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
