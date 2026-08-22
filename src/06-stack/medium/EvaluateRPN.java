/**
 * Problem: Evaluate an expression in Reverse Polish Notation.
 *
 * Approach: Use a stack.
 *   - Push numbers onto stack.
 *   - On operator, pop two operands, compute, push result.
 *
 * Time: O(n) | Space: O(n)
 */
import java.util.*;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (token) {
                        case "+": stack.push(a + b); break;
                        case "-": stack.push(a - b); break;
                        case "*": stack.push(a * b); break;
                        case "/": stack.push(a / b); break;
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + evalRPN(tokens));
        // Output: 9 ((2 + 1) * 3)

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result: " + evalRPN(tokens2));
        // Output: 6 (4 + (13 / 5))
    }
}
