import java.util.Arrays;
import java.util.Scanner;

public class _09_UniquePaths2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = in.nextInt();
            }
        }

//        int[][] dp = new int[n][m];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(countUniquePaths(n-1, m-1, grid, dp));
        System.out.println(countUniquePaths(n, m, grid));
    }

/*
    //Memoization
    private static int countUniquePaths(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == -1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = countUniquePaths(i-1, j, grid, dp);
        int left = countUniquePaths(i, j-1, grid, dp);
        return dp[i][j] = up + left;
    }
*/

/*
    //Tabulation
    private static int countUniquePaths(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = dp[i-1][j];
                    if (j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
*/

    private static int countUniquePaths(int n, int m, int[][] grid) {
        int[] prev = new int[m];

        for (int i=0; i<n; i++) {
            int[] curr = new int[m];
            for (int j=0; j<m; j++) {
                if (grid[i][j] == -1) {
                    curr[j] = 0;
                }
                else if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0) up = prev[j];
                    if (j > 0) left = curr[j-1];
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }

}
