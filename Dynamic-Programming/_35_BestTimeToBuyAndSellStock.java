import java.util.Scanner;

public class _35_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prices = new int[n];
        for (int i=0; i<n; i++) {
            prices[i] = in.nextInt();
        }

        System.out.println(getMaxProfit(n, prices));
    }

    private static int getMaxProfit(int n, int[] prices) {
        int maxProfit = 0;
        int minCost = prices[0];
        for (int i=1; i<n; i++) {
            int profit = prices[i] - minCost;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[i] < minCost) {
                minCost = prices[i];
            }
        }
        return maxProfit;
    }
}
