import java.util.Scanner;

public class _27_LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int n = s1.length();
        int m = s2.length();

        System.out.println(longestCommonSubstring(n, m, s1, s2));
    }
    //Tabulation
//    private static int longestCommonSubstring(int n, int m, String s1, String s2) {
//        int[][] dp = new int[n+1][m+1];
//        for (int j=0; j<=m; j++) {
//            dp[0][j] = 0;
//        }
//        for (int i=0; i<=n; i++) {
//            dp[i][0] = 0;
//        }
//        int result = 0;
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=m; j++) {
//                if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                    result = max(result, dp[i][j]);
//                } else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return result;
//    }

    //Space Optimization
    private static int longestCommonSubstring(int n, int m, String s1, String s2) {
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for (int j=0; j<=m; j++) {
            prev[j] = 0;
        }
        curr[0] = 0;

        int result = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                    result = max(result, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
            curr = new int[m+1];
        }
        return result;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
