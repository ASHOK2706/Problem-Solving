import java.util.Arrays;
import java.util.Scanner;

public class _41_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }

//        int[][] dp = new int[n][n+1];
//        for (int i=0 ;i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getLongestIncreasingSubsequence(0, -1, arr, dp));
        System.out.println(getLongestIncreasingSubsequence(n, arr));
    }

/*
    //Memoization
    private static int getLongestIncreasingSubsequence(int ind, int prevInd, int[] arr, int[][] dp) {
        if (ind == arr.length) {
            return 0;
        }
        if (dp[ind][prevInd+1] != -1) return dp[ind][prevInd+1];
        int length = getLongestIncreasingSubsequence(ind+1, prevInd, arr, dp);
        if (prevInd == -1 || arr[ind] > arr[prevInd]) {
            length = max(length, 1 + getLongestIncreasingSubsequence(ind+1, ind, arr ,dp));
        }
        return dp[ind][prevInd+1] = length;
    }
*/

/*
    //Tabulation
    private static int getLongestIncreasingSubsequence(int n, int[] arr) {
        int[][] dp = new int[n+1][n+1];
        for (int i=0; i<=n; i++) {
            dp[n][i] = 0;
        }

        for (int ind = n-1; ind >= 0; ind--) {
            for (int prevInd = ind-1; prevInd >= -1; prevInd--) {
                int length = dp[ind+1][prevInd + 1];
                if (prevInd == -1 || arr[ind] > arr[prevInd]) {
                    length = max(length, 1 + dp[ind+1][ind+1]);
                }
                dp[ind][prevInd+1] = length;
            }
        }

        return dp[0][-1+1];
    }
*/

    //Space optimization
    private static int getLongestIncreasingSubsequence(int n, int[] arr) {
        int[] next = new int[n+1];
        for (int i=0; i<=n; i++) {
            next[i] = 0;
        }

        for (int ind = n-1; ind >= 0; ind--) {
            int[] curr = new int[n+1];
            for (int prevInd = ind-1; prevInd >= -1; prevInd--) {
                int length = next[prevInd + 1];
                if (prevInd == -1 || arr[ind] > arr[prevInd]) {
                    length = max(length, 1 + next[ind+1]);
                }
                curr[prevInd+1] = length;
            }
            next = curr;
        }

        return next[-1+1];
    }




    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
