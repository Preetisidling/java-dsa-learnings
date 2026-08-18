/**
 * Problem: Find the length of the smallest subarray with sum >= target.
 *
 * Approach: Variable-size sliding window.
 *   - Expand window by adding elements from the right.
 *   - Once sum >= target, shrink from the left to find minimum length.
 *
 * Time: O(n) | Space: O(1)
 */
public class SmallestSubarrayWithSum {

    public static int smallestSubarray(int[] arr, int target) {
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];

            while (windowSum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                windowSum -= arr[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int target = 7;
        System.out.println("Smallest subarray length with sum >= " + target + ": " + smallestSubarray(arr, target));
        // Output: 2 (subarray [5, 2])
    }
}
