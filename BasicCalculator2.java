import java.util.Stack;

// TC: O(n) all the characters in the input string is visited.
// SC: O(h) stack is used to store the numbers where h is the maximum height of stack

// Runs successfully on leetcode
// when digits is detected, it is set to currentNumber. else based on he signs, further operation is executed.
public class BasicCalculator2 {
    public static void main(String[] args) {
        System.out.println(calculate("3+2*2")); // 7
        System.out.println(calculate(" 3/2 ")); // 1
        System.out.println(calculate(" 3+5 / 2")); // 5
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNumber = currentNumber * 10 + curr - '0';
            }
            if (!Character.isWhitespace(curr) && !Character.isDigit(curr) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                operation = curr;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
