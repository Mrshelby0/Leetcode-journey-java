class Solution {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * @param s The input string
     * @return The longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (center is a single character)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length palindrome centered at position i
            int len = Math.max(len1, len2);
            
            // Update the start and end positions if we found a longer palindrome
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    /**
     * Helper method to expand around center and find the length of palindrome.
     * 
     * @param s The input string
     * @param left Left pointer of the center
     * @param right Right pointer of the center
     * @return The length of the palindrome centered at (left, right)
     */
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as characters match and we're within bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Return the length of the palindrome
        // After the loop, left and right are one position beyond the palindrome
        return right - left - 1;
    }
}