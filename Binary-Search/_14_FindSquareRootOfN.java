/*
Given a positive integer n, find the square root of n. If n is not a perfect square, then return the floor value.

Floor value of any number is the greatest Integer which is less than or equal to that number

Examples:

Input: n = 4
Output: 2
Explanation: Since, 4 is a perfect square, so its square root is 2.
Input: n = 11
Output: 3
Explanation: Since, 11 is not a perfect square, floor of square root of 11 is 3.
*/

import java.util.Scanner;

public class _14_FindSquareRootOfN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println("Square Root value is : "+FindSqut(N));

        in.close();
    }

    private static int FindSqut(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid <= n) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }
}
