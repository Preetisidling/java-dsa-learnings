/**
 * Problem: Find the index of a target in a sorted array.
 *
 * Approach: Classic binary search.
 *   - Compare target with mid element.
 *   - Narrow the search to left or right half.
 *
 * Time: O(log n) | Space: O(1)
 */
public class BinarySearch {

    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Index of 7: " + search(arr, 7));
        // Output: 3
        System.out.println("Index of 4: " + search(arr, 4));
        // Output: -1
    }
}
