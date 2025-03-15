import java.util.Scanner;

public class _24_PaintersPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();

        System.out.println(getMinimizedLargestDistance(arr, n ,k));
        in.close();
    }

    private static int getMinimizedLargestDistance(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        int sumOfunits = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > max)  {
                max = arr[i];
            }
            sumOfunits += arr[i];
        }
        int low = max;
        int high = sumOfunits;
        while(low <= high) {
            int mid = (low + high) / 2;
            int noOfPainters = getNoOfPainters(arr, n, k, mid);
            if(noOfPainters > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int getNoOfPainters(int[] arr, int n, int k, int unit) {
        int noOfPainters = 1;
        int last = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] + last <= unit) {
                last += arr[i];
            }
            else {
                noOfPainters++;
                last = arr[i];
            }
        }
        return noOfPainters;
    }
}
