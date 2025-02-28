/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
*/

import java.util.Scanner;

public class _09_PowerExponentiation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int n = in.nextInt();
        System.out.println(x + " Power Of "+ n + " is : " + pow(x,n));
        in.close();
    }

    private static double pow(int x, int n) {
        long power = n;
        double answer = 1;
        if(n<0) power = -1 * power;
        while(power > 0) {
            if(power % 2 == 1) {
                answer = answer * x;
                power = power - 1;
            }
            else {
                power = power / 2;
                x = x * x;
            }
        }
        if (n < 0) return (double) 1 / answer;
        return answer;
    }

}
