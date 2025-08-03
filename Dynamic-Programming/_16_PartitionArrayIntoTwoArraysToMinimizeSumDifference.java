import java.util.Scanner;

public class _16_PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getMinimumDifference(n, arr));
    }

    private static int getMinimumDifference(int n, int[] arr) {
        int totalSum = 0;
        for (int i=0; i<n; i++) {
            totalSum += arr[i];
        }

        boolean[][] dp = new boolean[n][totalSum+1];
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        if(arr[0] <= totalSum) dp[0][arr[0]] = true;

        for (int i=1; i<n; i++) {
            for (int j=1; j<=totalSum; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[i-1][j-arr[i]];
                }
                dp[i][j] = take | notTake;
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<=totalSum/2; i++) {
            if(dp[n-1][i] == true) {
                int s1 = i;
                int s2 = totalSum - i;
                minDiff = min(minDiff, Math.abs(s1 - s2));
            }
        }
        return minDiff;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
