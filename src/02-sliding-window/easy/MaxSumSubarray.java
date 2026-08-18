/**
 * Problem: Find the maximum sum of a subarray of size k.
 *
 * Approach: Fixed-size sliding window.
 *   - Compute sum of first k elements.
 *   - Slide: add the next element, remove the first element of the window.
 *   - Track the maximum sum.
 *
 * Time: O(n) | Space: O(1)
 */
public class MaxSumSubarray {

    public static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of subarray of size " + k + ": " + maxSumSubarray(arr, k));
        // Output: 9 (subarray [5, 1, 3])
    }
}
