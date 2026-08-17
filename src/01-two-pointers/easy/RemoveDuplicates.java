/**
 * Problem: Remove duplicates from a sorted array in-place. Return the new length.
 *
 * Approach: Use two pointers — slow and fast.
 *   - Fast scans ahead; when it finds a new value, place it at slow+1.
 *
 * Time: O(n) | Space: O(1)
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 5, 5};
        int newLength = removeDuplicates(arr);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");
        }
        // Output: 1 2 3 4 5
    }
}
