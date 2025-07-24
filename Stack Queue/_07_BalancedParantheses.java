
import java.util.Scanner;
import java.util.Stack;

public class _07_BalancedParantheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(isBalanced(s));
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 == 1) return false;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                char ch = stack.pop();
                if(!(ch == '(' && s.charAt(i) == ')' || ch == '[' && s.charAt(i) == ']' || ch == '{' && s.charAt(i) == '}')) {
                    return false;
                }
            }
        }
        return true;
    }
}
