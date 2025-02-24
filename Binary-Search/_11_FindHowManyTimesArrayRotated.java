/*

*/

import java.util.Scanner;

public class _11_FindHowManyTimesArrayRotated {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Number Of Rotation is : "+FindHowManyTimesArrayRotated(arr, n));

        in.close();
    }
    private static int FindHowManyTimesArrayRotated(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[mid]) {
                if(arr[low] < minValue) {
                    minValue = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else {
                if(arr[mid] < minValue) {
                    minValue = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
