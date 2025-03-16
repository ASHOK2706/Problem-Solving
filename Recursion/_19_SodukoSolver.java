/*
LeetCode - 37 Sodoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
*/
public class _19_SodukoSolver {
    public static void main(String[] args) {
        char[][] board = { 
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solveSoduko(board);
        printBoard(board);
        
    }

    private static void solveSoduko(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if(solve(board) == true) {
                                return true;
                            }
                            else {
                                board[i][j] = '.' ;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int column, char ch) {
        for(int i=0; i<9 ;i++) {
            if(board[row][i] == ch) return false;
            if(board[i][column] == ch) return false;

            if (board[3 * (row / 3) + (i / 3)][3 * (column / 3) + (i % 3)] == ch) return false;
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
