/*
LeetCode - 22. Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3

Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/
import java.util.Scanner;

public class _16_GenerateParentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        generate("", 0, 0, n);
        in.close();
    }

    private static void generate(String s, int left, int right, int n) {
        if(left == n && right == n) {
            System.err.println(s);
            return;
        }
        if(right > left) return;
        if(left < n) generate(s + "(", left + 1, right, n);
        if(right < n) generate(s + ")", left, right + 1, n);
    }
}
