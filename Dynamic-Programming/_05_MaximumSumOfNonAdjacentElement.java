import java.util.Arrays;
import java.util.Scanner;

public class _05_MaximumSumOfNonAdjacentElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        System.out.println(getMaximumSum(n-1, arr, dp));
        System.out.println(getMaximumSum(n, arr));
    }
    //Memoization
//    private static int getMaximumSum(int ind, int[] arr, int[] dp) {
//        if (ind == 0) return arr[ind];
//        if (ind < 0) return 0;
//        if (dp[ind] != -1) return dp[ind];
//        int pick = arr[ind] + getMaximumSum(ind-2, arr, dp);
//        int notPick = getMaximumSum(ind-1, arr, dp);
//        return dp[ind] = max(pick, notPick);
//    }

    //Tabulation
//    private static int getMaximumSum(int n, int[] arr) {
//        int[] dp = new int[n];
//        dp[0] = arr[0];
//        for (int i=1; i<n; i++) {
//            int pick = arr[i];
//            if (i > 1) {
//                pick += dp[i-2];
//            }
//            int notPick = dp[i-1];
//            dp[i] = max(pick, notPick);
//        }
//        return dp[n-1];
//    }

    //Space Optimization
    private static int getMaximumSum(int n, int[] arr) {

        int prev1 = arr[0];
        int prev2 = 0;
        for (int i=1; i<n; i++) {
            int pick = arr[i] + prev2;
            int notPick = prev1;
            int curr = max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }



    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
