/**
 * Problem: Group strings that are anagrams of each other.
 *
 * Approach: Use sorted string as key in a HashMap.
 *   - Two strings are anagrams if their sorted forms are identical.
 *
 * Time: O(n * k log k) where k is max string length | Space: O(n * k)
 */
import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Grouped anagrams: " + result);
        // Output: [[eat, tea, ate], [tan, nat], [bat]]
    }
}
