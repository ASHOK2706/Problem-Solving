import java.util.Arrays;
import java.util.Scanner;

public class _12_MaximumFallingPathSum {
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
//        int maxi = Integer.MIN_VALUE;
//        for (int j=0; j<m; j++) {
//            maxi = max(maxi, getMaxSum(n-1, j ,grid, dp));
//        }
//        System.out.println(maxi);

        System.out.println(getMaxSum(n, m, grid));

    }

/*
    //Memoization
    private static int getMaxSum(int i, int j, int[][] grid, int[][] dp) {
        if (j < 0 || j >= grid[0].length) {
             return -1000000000;
        }
        if (i == 0) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) return dp[i][j];
        int s = grid[i][j] + getMaxSum(i-1, j, grid, dp);
        int ld = grid[i][j] + getMaxSum(i-1, j-1, grid, dp);
        int rd = grid[i][j] + getMaxSum(i-1, j+1, grid, dp);

        return dp[i][j] = max(s, max(ld, rd));
    }
*/


/*
    //Tabulation
    private static int getMaxSum(int n, int m, int[][] grid) {
        int[][] dp = new int[n][m];

        for (int j=0; j<m; j++) {
            dp[0][j] = grid[0][j];
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {

                int s = grid[i][j] + dp[i-1][j];
                int ld = -1000000000;
                if (j-1 >= 0) {
                    ld = grid[i][j] + dp[i-1][j-1];
                }
                int rd = -1000000000;
                if (j+1 < m) {
                    rd = grid[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = max(s, max(ld, rd));
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int j=0; j<m; j++) {
            maxi = max(maxi, dp[n-1][j]);
        }
        return maxi;
    }
*/

/*
    //Space Optimization
    private static int getMaxSum(int n, int m, int[][] grid) {
        int[] prev= new int[m];

        for (int j=0; j<m; j++) {
            prev[j] = grid[0][j];
        }

        for (int i=1; i<n; i++) {
            int[] curr = new int[m];
            for (int j=0; j<m; j++) {
                int s = grid[i][j] + prev[j];
                int ld = -1000000000;
                if (j-1 >= 0) {
                    ld = grid[i][j] + prev[j-1];
                }
                int rd = -1000000000;
                if (j+1 < m) {
                    rd = grid[i][j] + prev[j+1];
                }

                curr[j] = max(s, max(ld, rd));
            }
            prev = curr;
        }

        int maxi = Integer.MIN_VALUE;
        for (int j=0; j<m; j++) {
            maxi = max(maxi, prev[j]);
        }
        return maxi;
    }
*/

    // 0 Space Optimization
    private static int getMaxSum(int n, int m, int[][] grid) {

        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {

                int s = grid[i][j] + grid[i-1][j];
                int ld = -1000000000;
                if (j-1 >= 0) {
                    ld = grid[i][j] + grid[i-1][j-1];
                }
                int rd = -1000000000;
                if (j+1 < m) {
                    rd = grid[i][j] + grid[i-1][j+1];
                }

                grid[i][j] = max(s, max(ld, rd));
            }
        }

        int maxi = Integer.MIN_VALUE;
        for (int j=0; j<m; j++) {
            maxi = max(maxi, grid[n-1][j]);
        }
        return maxi;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
