import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _01_Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

//        int[] dp = new int[n+1];
//        Arrays.fill(dp, -1);
//        System.out.println(fibo(n, dp));
        System.out.println(fibo(n));
    }
    // Memoization
//    private static int fibo(int n, int[] dp) {
//        if (n <= 1) {
//            return n;
//        }
//        if (dp[n] != -1) return dp[n];
//        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
//    }

    //Tabulation
//    private static int fibo(int n) {
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i=2; i<=n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

    // Space Optimization
    private static int fibo(int n) {

        int prev2 = 0;
        int prev1 = 1;
        for (int i=2; i<=n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}
