/*
LeetCode - 51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and 
an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Input: n = 1
Output: [["Q"]]
*/
import java.util.Scanner;

public class _18_NQueens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solveNQueenes(n);
        in.close();
    }

    private static void solveNQueenes(int n) {
        char[][] board  = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0; j<n; j++) {
                board[i][j]='.';
            }
        }
        int[] leftRow = new int[n];
        int[] lowerDignal = new int[2*n-1];
        int[] upperDignal = new int[2*n-1];

        solve(0, board, n, leftRow, lowerDignal, upperDignal);
    }

    private static void solve(int column, char[][] board, int n,int[] leftRow, int[] lowerDignal, int[] upperDignal) {
        if(column == n) {
            System.out.println();
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(board[i][j] +" ");
                }
                System.out.println();
            }
            return;
        }


        for(int row = 0; row<n; row++) {
            if(leftRow[row] == 0 && lowerDignal[row+column] == 0 && upperDignal[(n-1) + (column - row)] == 0) {
                leftRow[row] = 1;
                lowerDignal[row+column] = 1;
                upperDignal[(n-1) + (column - row)] = 1;
                board[row][column] = 'Q';
                solve(column + 1, board, n, leftRow, lowerDignal, upperDignal);
                board[row][column] = '.';
                leftRow[row] = 0;
                lowerDignal[row+column] = 0;
                upperDignal[(n-1) + (column - row)] = 0;
            }
        }
    }
}
