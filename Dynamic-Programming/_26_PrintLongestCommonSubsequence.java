import java.util.Scanner;

public class _26_PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int n = s1.length();
        int m = s2.length();

        printLongestCommonSubsequence(n, m, s1, s2);
    }

    private static void printLongestCommonSubsequence(int n, int m, String s1, String s2) {
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


        String result = "";

        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                result = s1.charAt(i-1) + result;
                i--;
                j--;
            } else if (dp[i][j-1] >= dp[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }
        System.out.println(result);
    }

    private static int max(int x, int y) {
        return (x > y) ? x : y;
    }
}
