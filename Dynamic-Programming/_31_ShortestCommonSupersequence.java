import java.util.Arrays;
import java.util.Scanner;

public class _31_ShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i=0; i<=n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(n + m - lcs(n, m, s1, s2, dp));

        printShortestCommonSupersequence(n, m, s1, s2);
    }

    private static int lcs(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
            return dp[ind1][ind2] = 1 + lcs(ind1-1, ind2-1, s1, s2, dp);
        }
        return dp[ind1][ind2] = max(lcs(ind1-1, ind2, s1, s2, dp), lcs(ind1, ind2-1, s1, s2, dp));
    }


    private static void printShortestCommonSupersequence(int n, int m, String s1, String s2) {
        int[][] dp = new int[n+1][m+1];
        for (int j=0; j<=m; j++) {
            dp[0][j] = 0;
        }
        for (int i=0; i<=n; i++) {
            dp[i][0] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = n;
        int j = m;
        String result = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                result = s1.charAt(i-1) + result;
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                result = s1.charAt(i-1) + result;
                i--;
            } else {
                result = s2.charAt(j-1) + result;
                j--;
            }
        }
        while(i > 0) {
            result = s1.charAt(i-1) + result;
            i--;
        }
        while (j > 0) {
            result = s2.charAt(j-1) + result;
            j--;
        }
        System.out.println(result);
    }



    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
