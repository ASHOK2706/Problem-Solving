import java.util.Arrays;
import java.util.Scanner;

public class _24_RodCutting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i=0; i<n; i++) {
            prices[i] = in.nextInt();
        }

//        int[][] dp = new int[n][n+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(cutRod(n-1, n, prices, dp));
        System.out.println(cutRod(n, prices));
    }

/*
    //Memoization
    private static int cutRod(int ind, int N, int[] prices ,int[][] dp) {
        if (ind == 0) {
            return prices[ind] * N;
        }
        if (dp[ind][N] != -1) return dp[ind][N];
        int notTake = cutRod(ind-1, N, prices, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if (N>=rodLength) {
            take = prices[ind] + cutRod(ind, N-rodLength, prices, dp);
        }
        return dp[ind][N] = max(notTake, take);
    }
*/

/*
    //Tabulation
    private static int cutRod(int n, int[] prices) {
        int[][] dp = new int[n][n+1];
        for (int N = 0 ;N<=n; N++) {
            dp[0][N] = prices[0] * N;
        }
        for (int ind = 1; ind<n; ind++) {
            for (int N=0; N<=n; N++) {
                int notTake = dp[ind-1][N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (N>=rodLength) {
                    take = prices[ind] + dp[ind][N-rodLength];
                }
                dp[ind][N] = max(notTake, take);
            }
        }
        return dp[n-1][n];
    }
*/
/*
    //Space Optimization
    private static int cutRod(int n, int[] prices) {
        int[] prev= new int[n+1];
        for (int N = 0 ;N<=n; N++) {
            prev[N] = prices[0] * N;
        }
        for (int ind = 1; ind<n; ind++) {
            int[] curr= new int[n+1];
            for (int N=0; N<=n; N++) {
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (N>=rodLength) {
                    take = prices[ind] + curr[N-rodLength];
                }
                curr[N] = max(notTake, take);
            }
            prev = curr;
        }
        return prev[n];
    }
*/


    //Single Array Space Optimization
    private static int cutRod(int n, int[] prices) {
        int[] dp = new int[n+1];
        for (int N = 0 ;N<=n; N++) {
            dp[N] = prices[0] * N;
        }
        for (int ind = 1; ind<n; ind++) {
            for (int N=0; N<=n; N++) {
                int notTake = dp[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (N>=rodLength) {
                    take = prices[ind] + dp[N-rodLength];
                }
                dp[N] = max(notTake, take);
            }
        }
        return dp[n];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
