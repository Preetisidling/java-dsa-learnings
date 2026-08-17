/**
 * Problem: Given heights of lines, find two lines that form a container holding the most water.
 *
 * Approach: Two pointers from both ends.
 *   - Area = min(height[left], height[right]) * (right - left)
 *   - Move the pointer with the smaller height inward.
 *
 * Time: O(n) | Space: O(1)
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, water);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max water: " + maxArea(height));
        // Output: Max water: 49 (between index 1 and index 8)
    }
}
