class Solution {
    /**
     * Given an array of points on the X-Y plane, return the area of the largest triangle
     * that can be formed by any three different points.
     *
     * @param points Array of points where points[i] = [xi, yi]
     * @return The area of the largest triangle
     */
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        
        // Try all possible combinations of 3 points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate the area of triangle formed by points[i], points[j], points[k]
                    double area = calculateTriangleArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    /**
     * Calculate the area of a triangle given three points using the cross product formula.
     * Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
     *
     * @param p1 First point [x1, y1]
     * @param p2 Second point [x2, y2]
     * @param p3 Third point [x3, y3]
     * @return The area of the triangle
     */
    private double calculateTriangleArea(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        int x3 = p3[0], y3 = p3[1];
        
        // Using the shoelace formula (cross product method)
        // Area = 0.5 * |x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)|
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        
        return area;
    }
}