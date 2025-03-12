/*
LeetCode - 118. Pascal's Triangle
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]
*/

import java.util.Scanner;

public class _32_PascalTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPascalTriangle(n);
        in.close();
    }

    private static void printPascalTriangle(int n) {
        for(int i=1; i<=n; i++) {
            generateRow(i);
            System.out.println();
        }
    }

    private static void generateRow(int row) {
        int ans = 1;
        System.out.print(ans+" ");
        for(int col=1; col<row; col++) {
            ans = ans * (row - col) ;
            ans = ans / col;
            System.out.print(ans+" ");
        }
    }
}
