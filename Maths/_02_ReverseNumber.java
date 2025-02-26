/*
LeetCode - 7
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
signed 32-bit integer range [-231, 231 - 1], then return 0
*/
import java.util.Scanner;

public class _02_ReverseNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Reversed Of "+n+" is : "+reverseNumber(n));
        in.close();
    }

    private static int reverseNumber(int n) {
        long answer = 0;
        while (n != 0) {
            int remainder = n % 10;
            answer = (answer * 10) + remainder;
            if (answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE) return 0;
            n = n / 10; 
        }
        return (int)answer;
    }
}
