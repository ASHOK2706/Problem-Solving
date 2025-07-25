import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _32_DistinctSubsequences {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();

        int n = s1.length();
        int m = s2.length();

//        int[][] dp = new int[n+1][m+1];
//        for (int i=0;i<=n; i++) {
//            Arrays.fill(dp[i], -1);
//        }

        //System.out.println(countDistinctSubsequence(n, m, s1, s2, dp));

        System.out.println(countDistinctSubsequence(n, m, s1, s2));
    }
    //Memoization
//    private static int countDistinctSubsequence(int i, int j, String s1, String s2, int[][] dp) {
//        if (j == 0) return 1;
//        if (i == 0) return 0;
//        if (dp[i][j] != -1) return dp[i][j];
//        if (s1.charAt(i-1) == s2.charAt(j-1)) {
//            return dp[i][j] = countDistinctSubsequence(i-1, j-1, s1, s2, dp) + countDistinctSubsequence(i-1, j, s1, s2, dp);
//        }
//        return dp[i][j] = countDistinctSubsequence(i-1, j, s1, s2, dp);
//    }


    //Tabulation
//    private static int countDistinctSubsequence(int n, int m, String s1, String s2) {
//        int[][] dp = new int[n+1][m+1];
//        for (int i=0; i<=n; i++) {
//            dp[i][0] = 1;
//        }
//        for (int j=1; j<=m; j++) {
//            dp[0][j] = 0;
//        }
//
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                     dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//
//        return dp[n][m];
//    }


    //Space Optimization
//    private static int countDistinctSubsequence(int n, int m, String s1, String s2) {
//        int[] prev = new int[m+1];
//        int[] curr = new int[m+1];
//
//        prev[0] = curr[0] = 1;
//
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                    curr[j] = prev[j-1] + prev[j];
//                } else {
//                    curr[j] = prev[j];
//                }
//            }
//            prev = curr;
//            curr = new int[m+1];
//            curr[0] = 1;
//        }
//
//        return prev[m];
//    }

    // 1 D Array Optimization
    private static int countDistinctSubsequence(int n, int m, String s1, String s2) {
        int[] dp = new int[m+1];


        dp[0] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=m; j>=1; j--) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }

        return dp[m];
    }
}
