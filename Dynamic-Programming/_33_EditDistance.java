import java.util.Arrays;
import java.util.Scanner;

public class _33_EditDistance {
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
//        System.out.println(editDistance(n, m, s1, s2, dp));

        System.out.println(editDistance(n, m, s1, s2));

    }
    // Memoization
//    private static int editDistance(int i, int j, String s1, String s2, int[][] dp) {
//        if (i == 0) return j;
//        if (j == 0) return i;
//
//        if (dp[i][j] != -1) return dp[i][j];
//        if (s1.charAt(i-1) == s2.charAt(j-1)) {
//            return dp[i][j] = editDistance(i-1, j-1, s1, s2, dp);
//        }
//        return dp[i][j] = 1 + min(editDistance(i, j-1, s1, s2, dp), min(editDistance(i-1, j, s1, s2, dp), editDistance(i-1, j-1, s1, s2, dp)));
//    }

    //Tabulation
//    private static int editDistance(int n, int m, String s1, String s2) {
//        int[][] dp = new int[n+1][m+1];
//        for (int j=0; j<=m; j++) {
//            dp[0][j] = j;
//        }
//        for (int i=0; i<=n; i++) {
//            dp[i][0] = i;
//        }
//
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = 1 + min(dp[i][j-1], min(dp[i-1][j], dp[i-1][j-1]));
//                }
//            }
//        }
//
//        return dp[n][m];
//    }


    private static int editDistance(int n, int m, String s1, String s2) {
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int j=0; j<=m; j++) {
            prev[j] = j;
        }

        for (int i=1; i<=n; i++) {
            curr[0] = i;
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                } else {
                    curr[j] = 1 + min(curr[j-1], min(prev[j], prev[j-1]));
                }
            }
            prev = curr;
            curr = new int[m+1];
        }

        return prev[m];
    }

    private static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
