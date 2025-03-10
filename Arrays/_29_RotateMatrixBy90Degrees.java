/*
LeetCode - 48. Rotate Image
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 
2D matrix and do the rotation.
Example :
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
*/
import java.util.Scanner;

public class _29_RotateMatrixBy90Degrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        rotateMatrix(matrix, n);
        printMatrix(matrix, n);
        in.close();
    }

    private static void rotateMatrix(int[][] matrix, int n) {
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                swap(matrix, i, j);
            }
        }

        for(int i=0; i<n; i++) {
            reverse(matrix[i], 0, n-1);
        }
    }

    private static void swap(int[][] matrix , int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private static void reverse(int[] matrix, int left, int right) {
        while(left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }
    }

    private static void printMatrix(int[][] matrix, int n) {
        System.out.println();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
