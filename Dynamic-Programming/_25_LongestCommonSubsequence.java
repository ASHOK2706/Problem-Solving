import java.util.Arrays;
import java.util.Scanner;

public class _25_LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int n = s1.length();
        int m = s2.length();

//        int[][] dp = new int[n+1][m+1];
//        for (int i=0; i<=n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        System.out.println(getLongestCommonSubsequence(n, m, s1, s2 ,dp));

        System.out.println(getLongestCommonSubsequence(n, m, s1, s2));
    }

    //Memozation
//    private static int getLongestCommonSubsequence(int ind1, int ind2, String s1, String s2, int[][] dp) {
//        if(ind1 == 0 || ind2 == 0) {
//            return 0;
//        }
//
//        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
//
//        if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
//            return dp[ind1][ind2] = 1 + getLongestCommonSubsequence(ind1-1, ind2-1, s1, s2, dp);
//        }
//
//        return dp[ind1][ind2] = max(getLongestCommonSubsequence(ind1-1, ind2, s1, s2, dp) , getLongestCommonSubsequence(ind1, ind2-1, s1, s2, dp));
//    }


    //Tabulation
//    private static int getLongestCommonSubsequence(int n, int m, String s1, String s2) {
//        int[][] dp = new int[n+1][m+1];
//        for (int j=0; j<=m; j++) {
//            dp[0][j] = 0;
//        }
//        for (int i=0; i<=n; i++) {
//            dp[i][0] = 0;
//        }
//
//        for (int ind1 = 1; ind1<=n; ind1++) {
//            for (int ind2 = 1; ind2<=m; ind2++) {
//                if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
//                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
//                } else {
//                    dp[ind1][ind2] = max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
//                }
//            }
//        }
//        return dp[n][m];
//    }

    //Space Optimization
    private static int getLongestCommonSubsequence(int n, int m, String s1, String s2) {
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for (int j=0; j<=m; j++) {
            prev[j] = 0;
        }
        curr[0] = 0;


        for (int ind1 = 1; ind1<=n; ind1++) {
            for (int ind2 = 1; ind2<=m; ind2++) {
                if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
                    curr[ind2] = 1 + prev[ind2-1];
                } else {
                    curr[ind2] = max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    private static int max(int x, int y) {
        return (x > y) ? x : y;
    }
}
