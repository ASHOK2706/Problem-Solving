/*
Given an integer N, return the number of digits in N.
*/

import java.util.Scanner;

public class _01_CountDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("No Of Digits are : " + countDigit(n));
        in.close();
    }

    private static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n/10;
        }
        return count;
    }
}