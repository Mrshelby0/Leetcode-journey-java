import java.util.*;

class Solution {
    /**
     * Express n as a sum of only base-10 components, using the fewest base-10 components possible.
     * A base-10 component is the product of a single digit from 1 to 9 and a non-negative power of 10.
     * Examples: 500, 30, 7 are base-10 components; 537, 102, 11 are not.
     *
     * @param n The positive integer to decompose
     * @return Array containing base-10 components in descending order
     */
    public int[] getBaseComponents(int n) {
        List<Integer> components = new ArrayList<>();
        
        // Process each digit position from left to right (most significant to least significant)
        int powerOf10 = 1;
        
        // Find the highest power of 10 needed
        int temp = n;
        while (temp >= 10) {
            powerOf10 *= 10;
            temp /= 10;
        }
        
        // Extract components from most significant digit to least significant
        while (n > 0 && powerOf10 >= 1) {
            int digit = n / powerOf10; // Get the digit at current position
            
            if (digit > 0) {
                // Create base-10 component: digit * power of 10
                components.add(digit * powerOf10);
                n -= digit * powerOf10; // Remove this component from n
            }
            
            powerOf10 /= 10; // Move to next lower power of 10
        }
        
        // Convert list to array
        return components.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Alternative solution using string manipulation for clearer logic.
     */
    public int[] getBaseComponentsString(int n) {
        String numStr = String.valueOf(n);
        List<Integer> components = new ArrayList<>();
        
        // Process each digit position
        for (int i = 0; i < numStr.length(); i++) {
            char digitChar = numStr.charAt(i);
            int digit = digitChar - '0';
            
            if (digit > 0) {
                // Calculate the power of 10 for current position
                int powerOf10 = (int) Math.pow(10, numStr.length() - i - 1);
                components.add(digit * powerOf10);
            }
        }
        
        // Convert to array (already in descending order)
        return components.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Most concise solution using mathematical approach.
     */
    public int[] getBaseComponentsConcise(int n) {
        List<Integer> result = new ArrayList<>();
        int powerOf10 = 1;
        
        // Find the highest power of 10
        while (n / powerOf10 >= 10) {
            powerOf10 *= 10;
        }
        
        // Extract components
        while (powerOf10 > 0) {
            if (n >= powerOf10) {
                int digit = n / powerOf10;
                result.add(digit * powerOf10);
                n %= powerOf10;
            }
            powerOf10 /= 10;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}