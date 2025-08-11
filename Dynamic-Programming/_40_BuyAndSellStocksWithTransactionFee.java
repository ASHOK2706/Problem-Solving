import jdk.jshell.spi.SPIResolutionException;

import java.util.Arrays;
import java.util.Scanner;

public class _40_BuyAndSellStocksWithTransactionFee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i=0; i<n; i++) {
            prices[i] = in.nextInt();
        }
        int fee = in.nextInt();
//        int[][] dp = new int[n][2];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getMaxProfit(0, 1, prices, fee, dp));
        System.out.println(getMaxProfit(n, prices, fee));
    }

/*
    //Memoization
    private static int getMaxProfit(int ind, int buy, int[] prices, int fee, int[][] dp) {
        if (ind == prices.length) {
            return 0;
        }
        if (dp[ind][buy] != -1) return dp[ind][buy];
        if (buy == 1) {
            return dp[ind][buy] = max(-prices[ind] + getMaxProfit(ind+1, 0, prices, fee, dp), getMaxProfit(ind+1, 1, prices, fee, dp));
        }
        return dp[ind][buy] = max(prices[ind] - fee + getMaxProfit(ind+1, 1, prices, fee, dp), getMaxProfit(ind+1, 0, prices, fee, dp));
    }
*/

/*
    //Tabulation
    private static int getMaxProfit(int n, int[] prices ,int fee) {
        int[][] dp = new int[n+1][2];
        for (int ind = n-1; ind>=0; ind--) {
            for (int buy = 0; buy<=1; buy++) {
                if (buy == 1) {
                    dp[ind][buy] = max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                } else {
                    dp[ind][buy] = max(prices[ind] - fee + dp[ind+1][1], dp[ind+1][0]);
                }
            }
        }
        return dp[0][1];
    }
*/

    //Space Optimization
    private static int getMaxProfit(int n, int[] prices ,int fee) {
        int[] next = new int[2];
        for (int ind = n-1; ind>=0; ind--) {
            int[] curr = new int[2];
            for (int buy = 0; buy<=1; buy++) {
                if (buy == 1) {
                    curr[buy] = max(-prices[ind] + next[0], next[1]);
                } else {
                    curr[buy] = max(prices[ind] - fee + next[1], next[0]);
                }
            }
            next = curr;
        }
        return next[1];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
