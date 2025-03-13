import java.util.Scanner;

public class _05_IsPolindromString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(isPolindrom(s, 0, s.length()-1));
        in.close();
    }

    private static boolean isPolindrom(String s, int left, int right) {
        if(left >= right) return true;
        if(s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPolindrom(s, left + 1, right - 1);
    }
}
