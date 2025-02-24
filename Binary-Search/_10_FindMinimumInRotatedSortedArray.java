/*
LeetCode - 153
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, 

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
*/

import java.util.Scanner;
public class _10_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("minimum Value is : "+ FindMinimum(arr, n));

        in.close();
    }

    private static int FindMinimum(int[] arr, int n) {
        int low = 0;
        int high = n - 1;
        int minimumValue = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[mid]) {
                if(minimumValue > arr[low])
                    minimumValue = arr[low];
                low = mid + 1;
            }
            else {
                if(minimumValue > arr[mid])
                    minimumValue = arr[mid];
                high = mid - 1;
            }
        }
        return minimumValue;
    }
}