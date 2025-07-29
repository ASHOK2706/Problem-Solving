import java.util.Arrays;
import java.util.Scanner;

public class _04_FrogKJump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();

//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        System.out.println(jump(n-1, arr, k, dp));

        System.out.println(jump(n, arr, k));
    }

    // Memoization
//    private static int jump(int ind, int[] arr, int k, int[] dp) {
//        if (ind == 0) return 0;
//        if (dp[ind] != -1) return dp[ind];
//        int minimumJumpCost = Integer.MAX_VALUE;
//        for (int j=1; j<=k; j++) {
//            if (ind-j >= 0) {
//                int cost = jump(ind-j, arr, k, dp) + abs(arr[ind] - arr[ind-j]);
//                if (cost < minimumJumpCost) {
//                    minimumJumpCost = cost;
//                }
//            }
//        }
//        return dp[ind] = minimumJumpCost;
//    }

    //Tabulation
    private static int jump(int n, int[]arr, int k) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i=1; i<n; i++) {
            int minimumJumpCost = Integer.MAX_VALUE;
            for (int j=1; j<=k; j++) {
                if (i-j >= 0) {
                    int cost = dp[i-j] + abs(arr[i] - arr[i-j]);
                    if (cost < minimumJumpCost) {
                        minimumJumpCost = cost;
                    }
                } else break;
            }
            dp[i] = minimumJumpCost;
        }
        return dp[n-1];

    }

    private static int abs(int x) {
        return x < 0 ? -1 * x : x;
    }

}
