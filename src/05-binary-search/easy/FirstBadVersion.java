/**
 * Problem: Find the first bad version (versions 1..n where isBadVersion(v) returns true for bad ones).
 *
 * Approach: Binary search for the leftmost true.
 *   - If mid is bad, answer could be mid or earlier → go left.
 *   - If mid is good, answer is to the right → go right.
 *
 * Time: O(log n) | Space: O(1)
 */
public class FirstBadVersion {

    static int badVersion = 4; // simulated bad version

    static boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("First bad version: " + firstBadVersion(n));
        // Output: 4
    }
}
