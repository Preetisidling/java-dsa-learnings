/**
 * Problem: Find the length of the longest substring with at most k distinct characters.
 *
 * Approach: Variable-size sliding window with a HashMap to track character frequencies.
 *   - Expand window by adding characters.
 *   - When distinct count > k, shrink from the left.
 *
 * Time: O(n) | Space: O(k)
 */
import java.util.*;

public class LongestSubstringKDistinct {

    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char right = s.charAt(end);
            charFreq.put(right, charFreq.getOrDefault(right, 0) + 1);

            while (charFreq.size() > k) {
                char left = s.charAt(start);
                charFreq.put(left, charFreq.get(left) - 1);
                if (charFreq.get(left) == 0) {
                    charFreq.remove(left);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length: " + longestSubstring("araaci", 2));
        // Output: 4 ("araa")
        System.out.println("Length: " + longestSubstring("cbbebi", 3));
        // Output: 5 ("cbbeb")
    }
}
