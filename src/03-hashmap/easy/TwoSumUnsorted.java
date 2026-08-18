/**
 * Problem: Given an unsorted array, find two numbers that add up to a target. Return their indices.
 *
 * Approach: Use a HashMap to store each number's index.
 *   - For each number, check if (target - number) exists in the map.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.*;

public class TwoSumUnsorted {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        // Output: Indices: 0, 1 (because 2 + 7 = 9)
    }
}
