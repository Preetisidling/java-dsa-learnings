/**
 * Problem: Find the first non-repeating character in a string.
 *
 * Approach: Use a LinkedHashMap to maintain insertion order with frequency counts.
 *   - First pass: count frequencies.
 *   - Second pass: find the first character with count 1.
 *
 * Time: O(n) | Space: O(1) — at most 26 characters
 */
import java.util.*;

public class FirstNonRepeatingChar {

    public static char firstNonRepeating(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '_';
    }

    public static void main(String[] args) {
        System.out.println("First non-repeating: " + firstNonRepeating("aabbcde"));
        // Output: c
        System.out.println("First non-repeating: " + firstNonRepeating("aabb"));
        // Output: _
    }
}
