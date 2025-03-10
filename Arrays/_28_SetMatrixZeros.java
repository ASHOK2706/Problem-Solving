/*
LeetCode - 73. Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example :
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
*/

import java.util.Scanner;

public class _28_SetMatrixZeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in. nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0; i<m ;i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        setMatrixZeros(matrix , m , n);

        print(matrix, m, n);
        in.close();
    }

    private static void setMatrixZeros(int[][] matrix, int m, int n) {
        int[] row = new int[m];
        int[] colum = new int[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    colum[j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(row[i] == 1 || colum[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void print(int[][] matrix, int m, int n) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
