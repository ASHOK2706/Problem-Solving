import java.util.Arrays;
import java.util.Scanner;

public class _10_MinimumPathSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j]= in.nextInt();
            }
        }

//        int[][] dp = new int[m][n];
//        for (int i=0; i<m; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getMinimumPathSum(m-1, n-1, grid, dp));
        System.out.println(getMinimumPathSum(m-1, n-1, grid));
    }

/*
    //Memoization
    private static int getMinimumPathSum(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = grid[i][j] + getMinimumPathSum(i-1, j, grid, dp);
        int down = grid[i][j] + getMinimumPathSum(i, j-1, grid, dp);
        return dp[i][j] = min(up, down);
    }
*/

/*
    //Tabulation
    private static int getMinimumPathSum(int m, int n, int[][] grid) {
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if (i > 0) up = grid[i][j] + dp[i-1][j];
                    if (j > 0) down = grid[i][j] + dp[i][j-1];
                    dp[i][j] = min(up, down);
                }
            }
        }
        return dp[m-1][n-1];
    }
*/

    //Space Optimization
    private static int getMinimumPathSum(int m, int n, int[][] grid) {
        int[] prev = new int[n];
        for (int i=0; i<m; i++) {
            int[] curr = new int[n];
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if (i > 0) up = grid[i][j] + prev[j];
                    if (j > 0) down = grid[i][j] + curr[j-1];
                    curr[j] = min(up, down);
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }


}
