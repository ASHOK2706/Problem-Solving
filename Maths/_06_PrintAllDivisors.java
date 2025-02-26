/*
Example 1:
Input:N = 36
Output:[1, 2, 3, 4, 6, 9, 12, 18, 36]
Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.

Example 2:
Input:N =12
Output: [1, 2, 3, 4, 6, 12]
Explanation: The divisors of 12 are 1, 2, 3, 4, 6, 12.
*/

import java.util.Scanner;

public class _06_PrintAllDivisors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printAllDivisors(n);
        in.close();
    }

    private static void printAllDivisors(int n) {
        for (int i=1; i*i<=n; i++) {
            if (n%i==0) {
                System.out.print(i + " ");
                if (n/i != i) {
                    System.out.print(n/i+" ");
                }
            }
        }
    }
}
