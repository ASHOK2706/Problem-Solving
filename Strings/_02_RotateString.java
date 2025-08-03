//LeetCode - 796. Rotate String

import java.util.Scanner;

public class _02_RotateString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String goal = in.next();
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) return false;
        s = s + s;
        for (int i = n-1; i<s.length(); i++) {
            if (isMatching(s, goal, i-(n-1) ,i) == true) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMatching(String s, String goal, int start, int end) {
        for (int i=start; i<=end; i++) {
            if(s.charAt(i) != goal.charAt(i-start)) {
                return false;
            }
        }
        return true;
    }
}
