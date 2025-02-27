/*
LeetCode - 231
Given an integer n, return true if it is a power of two. Otherwise, return false.
*/
import java.util.Scanner;

public class _09_CheckTheNumberPowerOf2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isPowerOf2(n));
        in.close();
    }

    private static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
