// LeetCode - 1021. Remove Outermost Parentheses

import java.util.Scanner;

public class _01_RemoveOutermostParentheses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(removeOutermostParentheses(s));
    }

    private static String removeOutermostParentheses(String s) {
        StringBuffer str = new StringBuffer("");
        int count  = 0;
        char ch = '0';
        for (int i=0; i<s.length(); i++) {
            if (count == 0) {
                count = 1;
                ch = s.charAt(i);
            } else if (ch == s.charAt(i)) {
                count++;
                str.append(s.charAt(i));
            } else {
                count--;
                if (count != 0)
                    str.append(s.charAt(i));
            }
        }
        return new String(str);
    }
}
