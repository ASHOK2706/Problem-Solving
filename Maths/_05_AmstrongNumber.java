/*
LeetCode - 1134
Given an integer N, return true it is an Armstrong number otherwise return false.

An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits
*/

import java.util.Scanner;

public class _05_AmstrongNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(isAmstrongNumber(n) == true) {
            System.out.println(n + " is Amstrong Number");
        }
        else {
            System.out.println(n + " is Not an Amstrong Number");
        }
        in.close();
    }

    private static boolean isAmstrongNumber(int n) {
        int digit = countDigitOfN(n);
        int duplicate = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + findPOW(rem, digit);
            n = n / 10;
        }
        return duplicate == sum;
    }

    private static int countDigitOfN(int n) {
        int count = 0;
        while(n>0) {
            count += 1;
            n = n / 10;
        }
        return count;
    }

    private static int findPOW(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if(n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            else {
                x = x * x;
                n = n / 2;
            }
        }
        return ans;
    }
}
