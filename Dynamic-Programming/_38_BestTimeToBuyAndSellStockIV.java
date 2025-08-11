import java.util.Arrays;
import java.util.Scanner;

public class _38_BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i=0 ;i<n; i++) {
            prices[i] = in.nextInt();
        }
        int k = in.nextInt();
//        int[][][] dp = new int[n][2][k+1];
//        for(int i=0; i<n; i++) {
//            for (int j=0; j<2; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        System.out.println(getMaxProfit(0, 1, k, prices, dp));
        System.out.println(getMaxProfit(n, k, prices));
    }

/*
    //Memoization
    private static int getMaxProfit(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (ind == prices.length || cap == 0) {
            return 0;
        }
        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if (buy == 1) {
            return dp[ind][buy][cap] = max(-prices[ind] + getMaxProfit(ind+1, 0, cap, prices, dp), getMaxProfit(ind+1, 1, cap, prices, dp));
        }
        return dp[ind][buy][cap] = max(prices[ind] + getMaxProfit(ind+1, 1, cap-1, prices, dp), getMaxProfit(ind+1, 0, cap, prices, dp));
    }
*/

/*
    //Tabulation
    private static int getMaxProfit(int n, int k, int[] prices) {
        int[][][] dp = new int[n+1][2][k+1];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy<=1; buy++) {
                for (int cap=1; cap<=k; cap++) {
                    if (buy == 1) {
                        dp[ind][buy][cap] = max(-prices[ind] + dp[ind+1][0][cap], dp[ind+1][1][cap]);
                    } else {
                        dp[ind][buy][cap] = max(prices[ind] + dp[ind+1][1][cap-1], dp[ind+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
*/
    //Space Optimization
    private static int getMaxProfit(int n, int k, int[] prices) {
        int[][] next = new int[2][k+1];

        for (int ind = n-1; ind >= 0; ind--) {
            int[][] curr = new int[2][k+1];
            for (int buy = 0; buy<=1; buy++) {
                for (int cap=1; cap<=k; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = max(-prices[ind] + next[0][cap], next[1][cap]);
                    } else {
                        curr[buy][cap] = max(prices[ind] + next[1][cap-1], next[0][cap]);
                    }
                }
            }
        }

        return next[1][k];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
