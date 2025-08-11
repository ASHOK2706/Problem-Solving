import java.util.Arrays;
import java.util.Scanner;

public class _44_LongestDivisibleSubset {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        printLongestDivisibleSubset(n, arr);
    }

    private static void printLongestDivisibleSubset(int n, int[] arr) {

        Arrays.sort(arr);
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi = 0;
        int lastIndex = -1;
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j<i; j++) {
                if (arr[i] % arr[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (maxi < dp[i]) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        int[] ans = new int[maxi];
        ans[maxi-1] = arr[lastIndex];
        int ind = maxi-2;
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans[ind] = arr[lastIndex];
            ind--;
        }

        for (int i=0; i<maxi; i++) {
            System.out.print(ans[i] + " ");
        }

    }
}
