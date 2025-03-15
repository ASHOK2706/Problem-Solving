/*

*/
import java.util.Scanner;

public class _23_SplitArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(splitArrayMinimizeLargestSum(arr, n, k));
        in.close();
    }

    private static int splitArrayMinimizeLargestSum(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }

        int low = max;
        int high = sum;
        while(low <= high) {
            int mid = (low + high) / 2;
            int noOfSunarray = getNoOfSplitArray(arr, n, k, mid);
            if(noOfSunarray > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int getNoOfSplitArray(int[] arr, int n, int k, int minSum) {
        int noOfSunarray = 1;
        int lastSum = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] + lastSum <= minSum) {
                lastSum += arr[i];
            }
            else {
                noOfSunarray++;
                lastSum = arr[i];
            }
        }
        return noOfSunarray;
    }
}
