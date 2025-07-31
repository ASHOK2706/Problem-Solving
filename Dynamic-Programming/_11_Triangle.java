import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _11_Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] triangle = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                triangle[i][j] = in.nextInt();
            }
        }
//        int[][] dp = new int[n][n];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(triangleMinimumSum(0, 0, triangle, dp));
        System.out.println(triangleMinimumSum(n, triangle));

    }

/*
    //Memoization
    private static int triangleMinimumSum(int i, int j, int[][] triangle, int[][] dp) {
        if (i == triangle.length-1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) return dp[i][j];
        int down = triangle[i][j] + triangleMinimumSum(i+1, j, triangle, dp);
        int downRight = triangle[i][j] + triangleMinimumSum(i+1, j+1, triangle, dp);
        return dp[i][j] = min(down, downRight);
    }
*/

/*
    //Tabulation
    private static int triangleMinimumSum(int n, int[][] triangle) {
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = triangle[i][j] + dp[i+1][j];
                int downRight = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = min(down, downRight);
            }
        }
        return dp[0][0];
    }
*/

/*
    //Space Optimization
    private static int triangleMinimumSum(int n, int[][] triangle) {
        int[] next = new int[n];
        for (int i=0; i<n; i++) {
            next[i] = triangle[n-1][i];
        }
        for(int i=n-2; i>=0; i--) {
            int[] curr = new int[n];
            for (int j=0; j<=i; j++) {
                int down = triangle[i][j] + next[j];
                int downRight = triangle[i][j] + next[j+1];
                curr[j] = min(down, downRight);
            }
            next = curr;
        }
        return next[0];
    }
*/

    // 0 Space Optimization
    private static int triangleMinimumSum(int n, int[][] triangle) {
        for(int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                int down = triangle[i][j] + triangle[i+1][j];
                int downRight = triangle[i][j] + triangle[i+1][j+1];
                triangle[i][j] = min(down, downRight);
            }
        }
        return triangle[0][0];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }

}
