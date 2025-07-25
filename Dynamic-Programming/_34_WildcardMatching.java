import java.util.Arrays;
import java.util.Scanner;

public class _34_WildcardMatching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p = in.next();
        String s = in.next();

        int n = p.length();
        int m = s.length();

        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(match(n-1, m-1, p, s, dp) == 1 ? true : false);
    }

    //Memoization
    private static int match(int i, int j, String p, String s, int[][] dp) {

        if (i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (p.charAt(ii) != '*') return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = match(i-1, j-1, p, s, dp);
        }
        if (p.charAt(i) == '*') {
            return dp[i][j] = match(i-1, j, p, s, dp) | match(i, j-1, p, s, dp);
        }

        return dp[i][j] = 0;
    }




}
