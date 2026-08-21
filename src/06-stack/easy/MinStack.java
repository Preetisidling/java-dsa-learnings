/**
 * Problem: Design a stack that supports push, pop, top, and getMin in O(1).
 *
 * Approach: Use two stacks — one for values, one to track minimums.
 *   - On push, also push to min stack if value <= current min.
 *   - On pop, also pop from min stack if value equals current min.
 *
 * Time: O(1) for all operations | Space: O(n)
 */
import java.util.*;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(1);
        System.out.println("Min: " + ms.getMin()); // 1
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3
    }
}
