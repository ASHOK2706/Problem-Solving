import java.util.Arrays;
import java.util.Scanner;

public class _03_FrogJump {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        System.out.println(getMinimumCost(n-1, arr, dp));

        System.out.println(getMinimumCost(n, arr));
    }

    // Memoization
//    private static int getMinimumCost(int ind, int[] arr, int[] dp) {
//        if (ind == 0) return 0;
//        if (dp[ind] != -1) return dp[ind];
//        int left = getMinimumCost(ind-1, arr, dp) + abs(arr[ind] - arr[ind-1]);
//        int right = Integer.MAX_VALUE;
//        if (ind > 1) {
//            right = getMinimumCost(ind-2, arr, dp) + abs(arr[ind] - arr[ind-2]);
//        }
//        return dp[ind] = min(left, right);
//    }

    //Tabulation
//    private static int getMinimumCost(int n, int[] arr) {
//        int[] dp = new int[n];
//        dp[0] = 0;
//
//        for (int i=1; i<n; i++) {
//            int left = dp[i-1] + abs(arr[i] - arr[i-1]);
//            int right = Integer.MAX_VALUE;
//            if (i > 1) {
//                right = dp[i-2] + abs(arr[i] - arr[i-2]);
//            }
//            dp[i] = min(left, right);
//        }
//        return dp[n-1];
//    }

    //Space Optimization
    private static int getMinimumCost(int n, int[] arr) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i=1; i<n; i++) {
            int left = prev1 + abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + abs(arr[i] - arr[i-2]);
            }
            int curr = min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private static int abs(int x) {
        return x < 0 ? -1 * x : x;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
