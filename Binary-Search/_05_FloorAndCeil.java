/*
Problem statement:
-------------------
You're given a sorted array 'a' of 'n' integers and an integer 'x'.

Find the floor and ceiling of 'x' in 'a[0..n-1]'.

Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.
*/

import java.util.*;
public class _05_FloorAndCeil {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int x = in.nextInt();

        System.out.println("Floor and ceil is : "+Arrays.toString(GetFloorAndCeil(arr, n, x)));

        in.close();
    }

    private static int[] GetFloorAndCeil(int[] arr, int n, int x) {
        int floor = getFloor(arr, n, x);
        int ceil = getCeil(arr, n, x);

        return new int[]{floor, ceil};
    }

    private static int getFloor(int[] arr, int n, int x) {
        int low = 0;
        int high = n -1;
        int floor = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= x) {
                floor = arr[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return floor;
    }

    private static int getCeil(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ceil = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= x) {
                ceil = arr[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ceil;
    }
}
