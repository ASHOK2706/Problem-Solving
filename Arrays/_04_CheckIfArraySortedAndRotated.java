/*
LeetCode - 1752. Check if Array Is Sorted and Rotated
Given an array arr, return true if the array was originally sorted in non-decreasing order, then rotated some number 
of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] 
for every valid index i.

Example 1:
Input: arr = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].

Example 2:
Input: arr = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make arr.
*/

import java.util.Scanner;

public class _04_CheckIfArraySortedAndRotated {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(isSoretedAndRotated(arr, n));
        in.close();
    }

    private static boolean isSoretedAndRotated(int[] arr, int n) {
        int noOfBreakPoits = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] > arr[(i+1)%n]) {
                noOfBreakPoits++;
            }
        }
        return noOfBreakPoits <= 1;
    }

/*
    private static boolean isSoretedAndRotated(int[] arr, int n) {
        int breakPoint = -1;
        for(int i=0; i<n-1; i++) {
            if(arr[i] <= arr[i+1]){
                continue;
            }
            else {
                breakPoint = i+1;
                break;
            } 
        }

        if (breakPoint == -1) 
            return true;
        
        for(int i=breakPoint; i<n-1; i++) {
            if(arr[i] <= arr[i+1]) continue;
            else return false;
        }

        int left = breakPoint;
        int right = n-1;
        for(int i=0; i<breakPoint; i++) {
            if(arr[left] < arr[i] && arr[i] < arr[right]) 
                return false;
        }
        left = 0;
        right = breakPoint - 1;
        for(int i=breakPoint; i<n; i++) {
            if(arr[left] < arr[i] && arr[i] < arr[right]) 
                return false;
        }

        return true;
    } 
*/

   
}