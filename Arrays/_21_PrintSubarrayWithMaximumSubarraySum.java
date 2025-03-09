/*
Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.
*/
import java.util.Scanner;

public class _21_PrintSubarrayWithMaximumSubarraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        printMaximumSumSubarray(arr, n);
        in.close();
    }

    private static void printMaximumSumSubarray(int[] arr, int n) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        int start = 1;
        for(int i=0; i<n; i++) {
            if(sum == 0) {
                start = i;
            }
            sum += arr[i];
            if(sum > maxSum) {
                maxSum = sum;
                startIndex = start;
                endIndex = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum Sum : " +maxSum);
        System.out.println("Subarray : ");
        for(int i=startIndex; i<=endIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
