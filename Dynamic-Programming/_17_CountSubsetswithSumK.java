import java.util.Arrays;
import java.util.Scanner;

public class _17_CountSubsetswithSumK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt(); // K

//        int[][] dp = new int[n][target+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(countSubsets(n-1, target, arr, dp));
        System.out.println(countSubsets(n, target, arr));
    }

/*
    //Memoization
    private static int countSubsets(int ind, int target, int[] arr, int[][] dp) {
//        if (target == 0) {
//            return 1;
//        }
        if (ind == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }
        if (dp[ind][target] != -1) return dp[ind][target];
        int notTake = countSubsets(ind-1, target, arr, dp);
        int take = 0;
        if (target >= arr[ind]) {
            take = countSubsets(ind-1, target-arr[ind], arr, dp);
        }
        return dp[ind][target] = notTake + take;
    }
*/

/*
    //Tabulation
    private static int countSubsets(int n, int T, int[] arr) {
        int[][] dp = new int[n][T+1];
        for (int i=0; i<n; i++) {
            if (arr[0] == 0) dp[i][0] = 2;
            else dp[i][0] = 1;
        }
        //if(arr[0] <= T) dp[0][arr[0]] = 1;
        if(arr[0] <= T) {
            if (arr[0] != 0) prev[arr[0]] = 1;
        }

        for (int ind=1; ind<n; ind++) {
            for (int target = 1; target<=T; target++) {
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
    private static int countSubsets(int n, int T, int[] arr) {
        int[] prev = new int[T+1];
        if (arr[0] == 0) prev[0] = 2;
        else prev[0] = 1;

        if (arr[0] != 0 && arr[0] <= T) {
            prev[arr[0]] = 1;
        }



        for (int ind=1; ind<n; ind++) {
            int[] curr = new int[T+1];
            if (arr[0] == 0) curr[0] = 2;
            else curr[0] = 1;
            for (int target = 1; target<=T; target++) {
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
