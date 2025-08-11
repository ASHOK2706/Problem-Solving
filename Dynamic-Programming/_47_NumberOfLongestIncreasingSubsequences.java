import java.util.Scanner;

public class _47_NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getNoOfLIS(n, arr));
    }
    private static int getNoOfLIS(int n, int[] arr) {
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxi = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                } else if (arr[i] > arr[j] && dp[i] == 1 + dp[j]) {
                    count[i] += count[j];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }

        int noOfLIS = 0;
        for (int i=0; i<n; i++) {
            if (dp[i] == maxi) {
                noOfLIS += count[i];
            }
        }
        return noOfLIS;
    }
}
