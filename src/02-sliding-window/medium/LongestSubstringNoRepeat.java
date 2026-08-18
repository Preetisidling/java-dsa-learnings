/**
 * Problem: Find the length of the longest substring without repeating characters.
 *
 * Approach: Sliding window with a HashSet.
 *   - Expand window; if duplicate found, shrink from left until no duplicates.
 *
 * Time: O(n) | Space: O(min(n, alphabet size))
 */
import java.util.*;

public class LongestSubstringNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            while (seen.contains(s.charAt(end))) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length: " + lengthOfLongestSubstring("abcabcbb"));
        // Output: 3 ("abc")
        System.out.println("Length: " + lengthOfLongestSubstring("pwwkew"));
        // Output: 3 ("wke")
    }
}
