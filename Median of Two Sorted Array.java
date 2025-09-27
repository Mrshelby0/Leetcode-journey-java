class Solution {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     *
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return The median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // Total elements on the left side of partition
        
        int left = 0, right = m;
        
        while (left <= right) {
            // Partition nums1 at i and nums2 at j
            int i = (left + right) / 2;
            int j = totalLeft - i;
            
            // Get the elements around the partition
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
            
            // Check if we found the correct partition
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // Correct partition found
                if ((m + n) % 2 == 0) {
                    // Even total length - median is average of two middle elements
                    return (Math.max(nums1LeftMax, nums2LeftMax) + 
                            Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                } else {
                    // Odd total length - median is the maximum of left side
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if (nums1LeftMax > nums2RightMin) {
                // nums1 partition is too far right, move it left
                right = i - 1;
            } else {
                // nums1 partition is too far left, move it right
                left = i + 1;
            }
        }
        
        // This should never be reached if input arrays are valid
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}