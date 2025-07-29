import java.util.Arrays;
import java.util.Scanner;

public class _02_ClimbingStairs {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        int n = in.nextInt();

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        System.out.println(climb(n, dp));

        System.out.println(climb(n));

    }

    //Memoization
//    private static int climb(int n, int[] dp) {
//        if (n == 0) return 1;
//        if (n == 1) return 1;
//        if (dp[n] != -1) return dp[n];
//        int one = climb(n-1, dp);
//        int two = climb(n-2, dp);
//        return dp[n] = one + two;
//    }

    //Tabulation
//    private static int climb(int n) {
//        int[] dp =  new int[n+1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i=2; i<=n; i++) {
//            int one = dp[i-1];
//            int two = dp[i-2];
//            dp[i] = one + two;
//        }
//        return dp[n];
//    }


    //Space Optimization
    private static int climb(int n) {

        int prev1 = 1;
        int prev2 = 1;
        for (int i=2; i<=n; i++) {
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
