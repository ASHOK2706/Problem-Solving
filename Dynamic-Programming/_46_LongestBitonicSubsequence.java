import java.util.Scanner;

public class _46_LongestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getLongestBitonicSubsequence(n, arr));
    }

    private static int getLongestBitonicSubsequence(int n, int[] arr) {
        int[] dp1 = new int[n];
        for (int i=0; i<n; i++) {
            dp1[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dp1[i] < 1 + dp1[j]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }

        int[] dp2 = new int[n];
        for (int i=n-1; i>=0; i--) {
            dp2[i] = 1;
            for (int j=n-1; j>i; j--) {
                if (arr[i] > arr[j] && dp2[i] < 1 + dp2[j]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }

        int maxi = 0;
        for (int i=0; i<n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}
