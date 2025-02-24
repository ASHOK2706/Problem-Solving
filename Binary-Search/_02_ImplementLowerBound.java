/*
Problem Statement: Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

What is Lower Bound?
--------------------
The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater 
than or equal to a given key i.e. x.

The lower bound is the smallest index, ind, where arr[ind] >= x. But if any such index is not found, the lower bound 
algorithm returns n i.e. size of the given array.
*/

import java.util.*;
public class _02_ImplementLowerBound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        int x = in.nextInt();

        System.out.println(ImplementLowerBound(arr, x));

        in.close();
    }
    private static int ImplementLowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= x) {
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
