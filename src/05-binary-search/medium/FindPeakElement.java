/**
 * Problem: Find a peak element (strictly greater than its neighbors).
 *
 * Approach: Binary search — move toward the larger neighbor.
 *   - If mid+1 > mid, peak is to the right.
 *   - Otherwise, peak is to the left (including mid).
 *
 * Time: O(log n) | Space: O(1)
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Peak at index: " + findPeakElement(nums));
        // Output: 2 (value 3)

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak at index: " + findPeakElement(nums2));
        // Output: 5 (value 6)
    }
}
