/*
Given two integers N1 and N2, find their greatest common divisor.

The Greatest Common Divisor of any two integers is the largest number that divides both integers.
*/

import java.util.Scanner;

public class _04_GCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        System.out.println("GCD(" + n1 + ", " + n2 + ") is : " + findGCD(n1, n2));
        in.close();
    }

    private static int findGCD(int a, int b) {
        while(a > 0 && b > 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        if (a==0) return b;
        return a;
    }   
}
