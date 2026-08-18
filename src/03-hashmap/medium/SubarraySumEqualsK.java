/**
 * Problem: Find the total number of continuous subarrays whose sum equals k.
 *
 * Approach: Use prefix sum with a HashMap.
 *   - Store prefix sum frequencies.
 *   - If (currentSum - k) exists in the map, those many subarrays end here with sum k.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.*;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println("Count of subarrays with sum 2: " + subarraySum(nums, 2));
        // Output: 2 ([1,1] starting at index 0 and [1,1] starting at index 1)

        int[] nums2 = {1, 2, 3, -1, 2};
        System.out.println("Count of subarrays with sum 3: " + subarraySum(nums2, 3));
        // Output: 3
    }
}
