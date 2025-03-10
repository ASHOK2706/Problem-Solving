/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/

import java.util.Scanner;

public class _30_PrintMatrixSpiralManner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        printSpiral(matrix);
        in.close();

    }

    private static void printSpiral(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom) {
            for(int i=left; i<=right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if(top <= bottom) {
                for(int i=right; i>=left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if(left <= right) {
                for(int i=bottom; i>=top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        } 
    }
}
