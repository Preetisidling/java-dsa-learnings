/**
 * Problem: Search for a target in a rotated sorted array.
 *
 * Approach: Modified binary search.
 *   - Determine which half is sorted.
 *   - Check if target lies in the sorted half; narrow accordingly.
 *
 * Time: O(log n) | Space: O(1)
 */
public class SearchRotatedArray {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Index of 0: " + search(nums, 0));
        // Output: 4
        System.out.println("Index of 3: " + search(nums, 3));
        // Output: -1
    }
}
