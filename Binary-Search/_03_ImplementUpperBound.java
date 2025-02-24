/*
Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

What is Upper Bound?
--------------------
The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than 
the given key i.e. x.

The upper bound is the smallest index, ind, where arr[ind] > x.

But if any such index is not found, the upper bound algorithm returns n i.e. size of the given array. The main difference 
between the lower and upper bound is in the condition. For the lower bound the condition was arr[ind] >= x and here, 
in the case of the upper bound, it is arr[ind] > x.
*/

import java.util.*;
public class _03_ImplementUpperBound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int x = in.nextInt();
        System.out.println(ImplementUpperBound(arr, x));

        in.close();
    }
    private static int ImplementUpperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
