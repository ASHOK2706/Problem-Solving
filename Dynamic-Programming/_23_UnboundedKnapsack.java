import java.util.Arrays;
import java.util.Scanner;

public class _23_UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] wt = new int[n];
        for (int i=0; i<n; i++) {
            wt[i] = in.nextInt();
        }
        int[] value = new int[n];
        for (int i=0; i<n; i++) {
            value[i] = in.nextInt();
        }
        int maxWeight = in.nextInt();

//        int[][] dp = new int[n][maxWeight+1];
//        for (int i=0; i<n ;i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(unboundedKnapsack(n-1, maxWeight, wt, value, dp));
        System.out.println(unboundedKnapsack(n, maxWeight, wt, value));

    }

/*
    //Memoization
    private static int unboundedKnapsack(int ind, int w, int[] wt, int[] value, int[][] dp) {
        if (ind == 0) {
            return value[0] * (w / wt[0]);
        }
        if (dp[ind][w] != -1) return dp[ind][w];
        int notTake = unboundedKnapsack(ind-1, w, wt, value, dp);
        int take = Integer.MIN_VALUE;
        if (w >= wt[ind]) {
            take = value[ind] + unboundedKnapsack(ind, w-wt[ind], wt, value, dp);
        }
        return dp[ind][w] = max(notTake, take);
    }
*/

/*
    //Tabulation
    private static int unboundedKnapsack(int n, int maxWeight, int[] wt, int[] value) {
        int[][] dp = new int[n][maxWeight+1];
        for (int w=0; w<=maxWeight; w++) {
            dp[0][w] = value[0] * (w/wt[0]);
        }
        for (int ind=1; ind<n; ind++) {
            for (int w=0; w<=maxWeight; w++) {
                int notTake = dp[ind-1][w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[ind]) {
                    take = value[ind] + dp[ind][w-wt[ind]];
                }
                dp[ind][w] = max(notTake, take);
            }
        }
        return dp[n-1][maxWeight];
    }
*/

    //Space Optimization
    private static int unboundedKnapsack(int n, int maxWeight, int[] wt, int[] value) {
        int[]  prev = new int[maxWeight+1];
        for (int w=0; w<=maxWeight; w++) {
            prev[w] = value[0] * (w/wt[0]);
        }
        for (int ind=1; ind<n; ind++) {
            int[]  curr = new int[maxWeight+1];
            for (int w=0; w<=maxWeight; w++) {
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[ind]) {
                    take = value[ind] + curr[w-wt[ind]];
                }
                curr[w] = max(notTake, take);
            }
            prev = curr;
        }
        return prev[maxWeight];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
