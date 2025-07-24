import java.util.Arrays;
import java.util.Scanner;

public class _29_MinimumInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = reverseString(s1.toCharArray());
        int n = s1.length();

//        int[][] dp = new int[n+1][n+1];
//        for (int i=0; i<=n; i++) {
//            Arrays.fill(dp[i], -1);
//        }

        //System.out.println(n - getLongestCommonPolindromicSubsequence(n, n, s1, s2, dp));
        System.out.println(n - getLongestCommonPolindromicSubsequence(n, s1, s2));
    }

    //Memoization
//    private static int getLongestCommonPolindromicSubsequence(int ind1, int ind2, String s1, String s2, int[][] dp) {
//        if (ind1 == 0 || ind2 == 0) {
//            return 0;
//        }
//        if (dp[ind1][ind2] != -1) {
//            return dp[ind1][ind2];
//        }
//        if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
//            return dp[ind1][ind2] = 1 + getLongestCommonPolindromicSubsequence(ind1-1, ind2-1, s1, s2, dp);
//        }
//        return dp[ind1][ind2] = max(getLongestCommonPolindromicSubsequence(ind1-1, ind2, s1, s2, dp), getLongestCommonPolindromicSubsequence(ind1, ind2-1, s1, s2, dp));
//    }

    //Tabulation
//    private static int getLongestCommonPolindromicSubsequence(int n, String s1, String s2) {
//        int[][] dp = new int[n+1][n+1];
//        for (int j=0; j<=n; j++) {
//            dp[0][j] = 0;
//        }
//        for (int i=0; i<=n; i++) {
//            dp[i][0] = 0;
//        }
//
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=n; j++) {
//                if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                } else {
//                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[n][n];
//    }

    //Space Optimization
    private static int getLongestCommonPolindromicSubsequence(int n, String s1, String s2) {
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for (int j=0; j<=n; j++) {
            prev[j] = 0;
        }
        curr[0] = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
            curr = new int[n+1];
        }

        return prev[n];
    }


    private static String reverseString(char[] ch) {
        int i = 0;
        int j = ch.length - 1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(ch);
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}
