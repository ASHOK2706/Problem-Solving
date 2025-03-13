import java.util.Scanner;

public class _09_PrintNoOfSubsequencesWithSumk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(getNoOfSubsequennces(0, 0, k, arr, n));
        in.close();
    }

    private static int getNoOfSubsequennces(int i, int sum, int k, int[] arr, int n) {
        if(i == n) {
            if(sum == k) {
                return 1;
            }
            return 0;
        }
        sum += arr[i];
        int left = getNoOfSubsequennces(i+1, sum, k, arr, n);
        sum -= arr[i];
        int right = getNoOfSubsequennces(i+1, sum, k, arr, n);
        return left + right;
    }
}
