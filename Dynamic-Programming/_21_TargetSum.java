import java.util.Arrays;
import java.util.Scanner;

public class _21_TargetSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();

        /*
        in array some of elements goes to s1, and rest of the elements goes to s2
        s1 have the positive elements and s2 have negative elements
        difference of s1 and s2 is target

        s1 - s2 = target;
        s1 = totalSum - s2
        totalSum - s2 - s2 = target
        totalSum - target = 2s2
        s2 = (totalSum - target) / 2;

        so we find the count of subsequences whos sum is equal to [ (totalSum - target) / 2; ]
         */

        int totalSum = 0;
        for (int i=0; i<n; i++) {
            totalSum += arr[i];
        }

        if (totalSum - target < 0 || (totalSum - target) % 2 == 1) {
            System.out.println(0);
        } else {
            int T = (totalSum - target) / 2;
//            int[][] dp = new int[n][T+1];
//            for (int i=0; i<n; i++) {
//                Arrays.fill(dp[i], -1);
//            }
//            System.out.println(findTargetSumWays(n-1, T, arr, dp));
            System.out.println(findTargetSumWays(n, T, arr));
        }
    }

/*
    //Memoization
    private static int findTargetSumWays(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (arr[0] == 0 && target == 0) return 2;
            if (arr[0] != 0 && target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        int notTake = findTargetSumWays(ind-1, target, arr, dp);
        int take = 0;
        if (target >= arr[ind]) {
            take = findTargetSumWays(ind-1, target-arr[ind], arr, dp);
        }

        return dp[ind][target] = notTake + take;
    }
*/

/*
    //Tabulation
    private static int findTargetSumWays(int n, int T, int[] arr) {
        int[][] dp = new int[n][T+1];
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if (arr[0] != 0 && arr[0] <= T) dp[0][arr[0]] = 1;
        for  (int ind = 1; ind<n; ind++) {
            for (int target=0; target<=T; target++) {
                int notTake = dp[ind-1][target];
                int take = 0;
                if (target >= arr[ind]) {
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = notTake + take;
            }
        }
        return dp[n-1][T];
    }
*/

    //Space Optimization
    private static int findTargetSumWays(int n, int T, int[] arr) {
        int[] prev = new int[T+1];
        if(arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;
        if (arr[0] != 0 && arr[0] <= T) prev[arr[0]] = 1;
        for  (int ind = 1; ind<n; ind++) {
            int[] curr = new int[T+1];
            for (int target=0; target<=T; target++) {
                int notTake = prev[target];
                int take = 0;
                if (target >= arr[ind]) {
                    take = prev[target-arr[ind]];
                }
                curr[target] = notTake + take;
            }
            prev = curr;
        }
        return prev[T];
    }


}
