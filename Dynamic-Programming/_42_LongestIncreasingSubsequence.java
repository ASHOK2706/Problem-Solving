import javax.crypto.spec.PSource;
import java.util.Scanner;

public class _42_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        //System.out.println(getLIS(n, arr));
        printLIS(n, arr);
    }

/*
    //Algorithmic Approach for getting length of longest increasing subsequence.
    private static int getLIS(int n, int[] arr) {
        int[] dp = new int[n];
        int maxi = 0;
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j = 0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
            }
        }
        return maxi;
    }
*/

    //Printing Longest Increasing Subsequence
    private static void printLIS(int n, int[] arr) {
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 0;
        int lastIndex = 0;
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j = 0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        int[] lis = new int[maxi];
        lis[maxi-1] = arr[lastIndex];
        int ind = maxi-2;
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lis[ind] = arr[lastIndex];
            ind--;
        }

        for (int i=0; i<maxi; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}
