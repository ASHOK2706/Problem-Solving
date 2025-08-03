import java.util.Arrays;
import java.util.Scanner;

public class _20_MinimumCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = in.nextInt();
        }
        int amount = in.nextInt();
        int[][] dp = new int[n][amount+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        int minimumNoOfCoins = getMinimumCoins(n-1, amount, coins, dp);
        int minimumNoOfCoins = getMinimumCoins(n, amount, coins);
        System.out.println(minimumNoOfCoins == 0 ? -1 : minimumNoOfCoins);
    }

/*
    //Memoization
    private static int getMinimumCoins(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return 1000000000;
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = getMinimumCoins(ind-1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if (amount >= coins[ind]) {
            take = 1 + getMinimumCoins(ind, amount-coins[ind], coins, dp);
        }
        return dp[ind][amount] = min(notTake, take);
    }
*/

/*
    //Tabulation
    private static int getMinimumCoins(int n, int A, int[] coins) {
        int[][] dp = new int[n][A+1];
        for (int amount=0; amount<=A; amount++) {
            if (amount % coins[0] == 0) {
                dp[0][amount] = amount / coins[0];
            } else {
                dp[0][amount] = 1000000000;
            }
        }
        for (int ind=1; ind<n; ind++) {
            for (int amount=0; amount<=A; amount++) {
                int notTake = dp[ind-1][amount];;
                int take = Integer.MAX_VALUE;
                if (amount >= coins[ind]) {
                    take = 1 + dp[ind][amount-coins[ind]];
                }
                dp[ind][amount] = min(notTake, take);
            }
        }
        return dp[n-1][A];
    }
*/
    //Space Optimization
    private static int getMinimumCoins(int n, int A, int[] coins) {
        int[] prev= new int[A+1];
        for (int amount=0; amount<=A; amount++) {
            if (amount % coins[0] == 0) {
                prev[amount] = amount / coins[0];
            } else {
                prev[amount] = 1000000000;
            }
        }

        for (int ind=1; ind<n; ind++) {
            int[] curr = new int[A+1];
            for (int amount=0; amount<=A; amount++) {
                int notTake = prev[amount];;
                int take = Integer.MAX_VALUE;
                if (amount >= coins[ind]) {
                    take = 1 + curr[amount-coins[ind]];
                }
                curr[amount] = min(notTake, take);
            }
        }
        return prev[A];
    }


    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
