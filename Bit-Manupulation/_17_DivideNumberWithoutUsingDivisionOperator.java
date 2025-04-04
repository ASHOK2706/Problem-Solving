/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be 
truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 
32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, 
then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
*/

import java.util.Scanner;

public class _17_DivideNumberWithoutUsingDivisionOperator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dividend = in.nextInt();
        int dovisor = in.nextInt();
        System.out.println(divide(dividend, dovisor));
        in.close();
    }

    private static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(dividend >= 0 && divisor < 0) sign = false;
        if(dividend < 0 && divisor > 0) sign = false;

        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        long quiotent = 0;

        while(n >= d) {
            long count = 0;
            while( n >= (d << (count + 1)) ) {
                count++;
            }
            quiotent += 1 << count;
            n -= d << count;
        }
        if(quiotent >= Integer.MAX_VALUE && sign) {
            return Integer.MAX_VALUE;
        }
        if(quiotent >= Integer.MAX_VALUE && !sign) {
            return Integer.MIN_VALUE;
        }

        return (sign == true) ? (int)quiotent : -1 * (int)quiotent;

    }
}
