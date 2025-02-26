/*
LeetCode - 9
Given an integer x, return true if x is a palindrome, and false otherwise.
Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome
*/

import java.util.Scanner;

public class _03_PolindromNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(isPolindromNumber(n));
        in.close();
    }

    private static boolean isPolindromNumber(int n) {
        int originalnumber = n;
        int reversedNumber = 0;
        while(n > 0) {
            int remainder = n % 10;
            reversedNumber = (reversedNumber * 10) + remainder;
            n = n / 10;
        }
        return originalnumber == reversedNumber;
    }
}
