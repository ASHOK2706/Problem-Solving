import java.util.Arrays;
import java.util.Scanner;

public class _45_LongestStringChain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.next();
        }
        System.out.println(getLongestStringChain(n, arr));
    }

    private static int getLongestStringChain(int n, String[] arr) {
        int[] dp = new int[n];
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int maxi = 0;
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (check(arr[i], arr[j]) && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;
    }
    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()+1) return false;
        int first = 0;
        int second = 0;
        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        if (first == s1.length() && second == s2.length()) return true;
        return false;
    }
}
