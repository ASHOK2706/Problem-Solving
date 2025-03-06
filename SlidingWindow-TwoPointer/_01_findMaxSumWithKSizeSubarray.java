import java.util.Scanner;

public class _01_findMaxSumWithKSizeSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(findMaxSum(arr, k));
        in.close();
    }

    private static int findMaxSum(int[] arr, int k) {
        int n =arr.length;
        int sum = 0;
        int maxSum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        maxSum = sum;

        int left = 0;
        int right = k;
        while(right < n) {
            sum -= arr[left];
            left++;
            sum += arr[right];
            right++;
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
