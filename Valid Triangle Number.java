import java.util.Arrays;

class Solution {
    /**
     * Given an integer array nums, return the number of triplets chosen from the array
     * that can make triangles if we take them as side lengths of a triangle.
     *
     * @param nums The input integer array.
     * @return The number of valid triangle triplets.
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // Sort the array to easily apply the triangle inequality theorem.
        // For a triangle with sides a, b, c, if a <= b <= c, we only need to check a + b > c.
        Arrays.sort(nums);

        int count = 0;
        // Iterate from the end of the array, considering each element as the largest side 'c' of a potential triangle.
        for (int k = nums.length - 1; k >= 2; k--) {
            int left = 0;
            int right = k - 1;

            // Use a two-pointer approach to find pairs (a, b) such that a + b > c.
            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    // If nums[left] + nums[right] > nums[k], then any element between
                    // left and right, when paired with nums[right], will also satisfy the condition.
                    // This is because nums[left] is the smallest element in the current window.
                    // So, there are (right - left) such valid pairs.
                    count += (right - left);
                    right--; // Try a smaller 'b' to find more triangles.
                } else {
                    // The sum is not large enough, so we need a larger 'a'.
                    left++;
                }
            }
        }

        return count;
    }
}
