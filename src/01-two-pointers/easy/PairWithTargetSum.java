/**
 * Problem: Given a sorted array, find a pair whose sum equals the target.
 *
 * Approach: Use two pointers — one at start, one at end.
 *   - If sum == target, found the pair.
 *   - If sum < target, move left pointer right.
 *   - If sum > target, move right pointer left.
 *
 * Time: O(n) | Space: O(1)
 */
public class PairWithTargetSum {

    public static int[] findPair(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
        int[] result = findPair(arr, target);
        System.out.println("Pair found at indices: " + result[0] + ", " + result[1]);
        // Output: Pair found at indices: 1, 3 (because 2 + 4 = 6)
    }
}
