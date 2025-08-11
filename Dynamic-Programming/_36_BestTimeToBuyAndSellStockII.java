import java.util.Arrays;
import java.util.Scanner;

public class _36_BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i=0; i<n; i++) {
            prices[i] = in.nextInt();
        }
//        int[][] dp = new int[n][2];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getMaxProfit(0, 1, prices, dp));
        System.out.println(getMaxProfit(n, prices));
    }

/*
    //Memoization
    private static int getMaxProfit(int ind, int buy, int[] prices, int[][] dp) {
        if (ind == prices.length) {
            return 0;
        }
        if  (dp[ind][buy]  != -1) return dp[ind][buy];
        int profit = 0;
        if (buy == 1) {
            profit = max(-prices[ind] + getMaxProfit(ind+1, 0, prices, dp), getMaxProfit(ind+1, 1, prices, dp));
        } else {
            profit = max(prices[ind] + getMaxProfit(ind+1, 1, prices, dp), getMaxProfit(ind+1, 0, prices, dp));
        }
        return dp[ind][buy] = profit;
    }
*/

/*
    //Tabulation
    private static int getMaxProfit(int n ,int[] prices) {
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    profit = max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                } else {
                    profit = max(prices[ind] + dp[ind+1][1], dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }
*/

/*
    //Space Optimization
    private static int getMaxProfit(int n, int[] prices) {
        int[] next = new int[2];
        next[0] = next[1] = 0;
        for (int ind = n-1; ind >= 0; ind--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    profit = max(-prices[ind] + next[0], next[1]);
                } else {
                    profit = max(prices[ind] + next[1], next[0]);
                }
                curr[buy] = profit;
            }
            next = curr;
        }
        return next[1];
    }
*/

    private static int getMaxProfit(int n, int[] prices) {
        int nextNotBuy = 0;
        int nextBuy = 0;
        int currNotBuy = 0;
        int currBuy = 0;

        for (int ind = n-1; ind >= 0; ind--) {
            currNotBuy = max(prices[ind] + nextBuy, nextNotBuy);
            currBuy = max(-prices[ind] + nextNotBuy, nextBuy);
            nextNotBuy = currNotBuy;
            nextBuy = currBuy;
        }
        return nextBuy;
    }
    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
