class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is 0, the result is always 0
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Check for negative result using XOR: true if only one of them is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to handle overflow, and take absolute values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        long integerPart = num / den;
        result.append(integerPart);

        // Get remainder to start decimal part
        long remainder = num % den;
        if (remainder == 0) return result.toString(); // no decimal part

        result.append("."); // start decimal part

        // Map to store remainder -> position in result
        Map<Long, Integer> map = new HashMap<>();

        // Loop until remainder becomes 0 or we detect a repeating remainder
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // Repeating remainder found, insert parentheses
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            // Store current remainder with its position in result
            map.put(remainder, result.length());

            remainder *= 10;            // Bring down next digit
            long digit = remainder / den; // Get next decimal digit
            result.append(digit);       // Append digit to result
            remainder %= den;           // Update remainder
        }

        return result.toString();
    }

    public static void main(String[] args) {
        
    }
}