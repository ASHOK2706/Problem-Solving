import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _14_SubsetSumEqualsToTarget {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();

//        int[][] dp = new int[n][target+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(isSubsetSum(n-1, target, arr, dp) == 1);
        System.out.println(isSubsetSum(n, target, arr));
    }

/*
    //Memoization
    private static int isSubsetSum(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (ind == 0) {
           if(arr[0] == target)  {
               return 1;
           }
           return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        int notTake = isSubsetSum(ind-1, target, arr, dp);
        int take = 1;
        if (target >= arr[ind]) {
            take = isSubsetSum(ind-1, target-arr[ind], arr, dp);
        }
        return dp[ind][target] = notTake | take;
    }
*/

/*
    //Tabulation
    private static boolean isSubsetSum(int n, int T, int[] arr) {
        boolean[][] dp = new boolean[n][T+1];
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= T) dp[0][arr[0]] = true;
        for (int ind=1; ind<n; ind++) {
            for (int target=1; target<=T; target++) {
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if (target >= arr[ind]) {
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = notTake | take;
            }
        }
        return dp[n-1][T];
    }
*/
    //Space Optimization
    private static boolean isSubsetSum(int n, int T, int[] arr) {
        boolean[] prev = new boolean[T+1];
        prev[0] = true;
        if (arr[0] <= T) prev[arr[0]] = true;
        for (int ind=1; ind<n; ind++) {
            boolean[] curr = new boolean[T+1];
            curr[0] = true;
            for (int target=1; target<=T; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (target >= arr[ind]) {
                    take = prev[target-arr[ind]];
                }
                curr[target] = notTake | take;
            }
            prev = curr;
        }
        return prev[T];
    }
}
