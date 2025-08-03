import java.util.Arrays;
import java.util.Scanner;

public class _22_CoinChangeII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = in.nextInt();
        }
        int amount = in.nextInt();
//        int[][] dp = new int[n][amount+1];
//        for (int i=0; i<n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getNoOfCombinations(n-1, amount, coins, dp));
        System.out.println(getNoOfCombinations(n, amount, coins));
    }

/*
    //Memoization
    private static int getNoOfCombinations(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }
        if (dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = getNoOfCombinations(ind-1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[ind]) {
            take = getNoOfCombinations(ind, amount-coins[ind], coins, dp);
        }
        return dp[ind][amount] = notTake + take;
    }
*/

/*
    //Tabulation
    private static int getNoOfCombinations(int n, int A, int[] coins) {
        int[][] dp = new int[n][A+1];
        for (int amount=0; amount<=A; amount++) {
            if (amount % coins[0] == 0) {
                dp[0][amount] = 1;
            } else {
                dp[0][amount] = 0;
            }
        }
        for (int ind=1; ind<n; ind++) {
            for (int amount = 0; amount<=A; amount++) {
                int notTake = dp[ind-1][amount];
                int take = 0;
                if (amount >= coins[ind]) {
                    take = dp[ind][amount-coins[ind]];
                }
                dp[ind][amount] = notTake + take;
            }
        }
        return dp[n-1][A];
    }
*/
    //Space Optimization
    private static int getNoOfCombinations(int n, int A, int[] coins) {
        int[] prev = new int[A+1];
        for (int amount=0; amount<=A; amount++) {
            if (amount % coins[0] == 0) {
                prev[amount] = 1;
            } else {
                prev[amount] = 0;
            }
        }

        for (int ind=1; ind<n; ind++) {
            int[] curr = new int[A+1];
            for (int amount = 0; amount<=A; amount++) {
                int notTake = prev[amount];
                int take = 0;
                if (amount >= coins[ind]) {
                    take = curr[amount-coins[ind]];
                }
                curr[amount] = notTake + take;
            }
            prev = curr;
        }
        return prev[A];
    }
}
