import java.util.Arrays;
import java.util.Scanner;

public class _19_0_1KnapsackProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] wt = new int[n];
        int[] value = new int[n];
        for (int i=0; i<n; i++) {
            wt[i] = in.nextInt();
        }
        for (int i=0; i<n; i++) {
            value[i] = in.nextInt();
        }
        int maxWeight = in.nextInt();

//        int[][] dp = new int[n][maxWeight+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(knapsack0_1(n-1, maxWeight, wt, value, dp));
        System.out.println(knapsack0_1(n, maxWeight, wt, value));
    }

/*
    //Memoization
    private static int knapsack0_1(int ind, int w, int[] wt, int[] value, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= w) {
                return value[0];
            }
            return 0;
        }
        if (dp[ind][w] != -1) return dp[ind][w];
        int notTake = knapsack0_1(ind-1, w, wt, value, dp);
        int take = Integer.MIN_VALUE;
        if (w >= wt[ind]) {
            take = value[ind] + knapsack0_1(ind-1, w - wt[ind], wt, value, dp);
        }
        return dp[ind][w] = max(notTake, take);
    }
*/

/*
    //Tabulation
    private static int knapsack0_1(int n, int maxWeight, int[] wt, int[] value) {
        int[][] dp = new int[n][maxWeight+1];
        for (int w=wt[0]; w<=maxWeight; w++) {
            dp[0][w] = value[0];
        }
        for (int ind = 1; ind <n; ind++) {
            for (int w=0; w<=maxWeight; w++) {
                int notTake = dp[ind-1][w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[ind]) {
                    take = value[ind] + dp[ind-1][w - wt[ind]];
                }
                dp[ind][w] = max(notTake, take);
            }
        }
        return dp[n-1][maxWeight];
    }
*/

/*
    //Space Optimization
    private static int knapsack0_1(int n, int maxWeight, int[] wt, int[] value) {
        int[] prev = new int[maxWeight+1];
        for (int w=wt[0]; w<=maxWeight; w++) {
            prev[w] = value[0];
        }
        for (int ind = 1; ind <n; ind++) {
            int[] curr = new int[maxWeight+1];
            for (int w=0; w<=maxWeight; w++) {
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[ind]) {
                    take = value[ind] + prev[w - wt[ind]];
                }
                curr[w] = max(notTake, take);
            }
            prev = curr;
        }
        return prev[maxWeight];
    }
*/

    // Single Array Space Optimization
    private static int knapsack0_1(int n, int maxWeight, int[] wt, int[] value) {
        int[] dp = new int[maxWeight+1];
        for (int w=wt[0]; w<=maxWeight; w++) {
            dp[w] = value[0];
        }
        for (int ind = 1; ind <n; ind++) {
            for (int w=maxWeight; w>=0; w--) {
                int notTake = dp[w];
                int take = Integer.MIN_VALUE;
                if (w >= wt[ind]) {
                    take = value[ind] + dp[w - wt[ind]];
                }
                dp[w] = max(notTake, take);
            }
        }
        return dp[maxWeight];
    }
    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
