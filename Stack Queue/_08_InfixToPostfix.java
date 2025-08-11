import java.util.Scanner;
import java.util.Stack;

public class _08_InfixToPostfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String postfix = convertInfixToPostfix(s);
        System.out.println(postfix);
    }

    private static String convertInfixToPostfix(String s) {
        int n = s.length();
        int i=0;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        while (i<n) {
            char ch = s.charAt(i);
            if (isOperand(ch)) {
                ans = ans + ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans = ans + stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(ch) <= getPriority(stack.peek())) {
                    ans = ans + stack.pop();
                }
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    private static boolean isOperand(char ch) {
        return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9';
    }

    private static int getPriority(char ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        }
        return -1;
    }
}
