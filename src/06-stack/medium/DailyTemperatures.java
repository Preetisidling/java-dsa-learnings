/**
 * Problem: Given daily temperatures, find how many days until a warmer temperature for each day.
 *
 * Approach: Monotonic decreasing stack (store indices).
 *   - For each temperature, pop from stack while current > stack top.
 *   - The difference in indices gives the answer for each popped element.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.*;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temps);
        System.out.println("Days to wait: " + Arrays.toString(result));
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
