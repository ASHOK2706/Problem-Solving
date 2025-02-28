/*
LeetCode - 1283 
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, 
divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned 
above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. 
(For example: 7/3 = 3 and 10/2 = 5).

Example 1:
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44
*/

import java.util.Scanner;

public class _18_FindSmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int threshold = in.nextInt();
        System.out.println(findSmallestDivisor(arr, threshold));
        in.close();
    }

    private static int findSmallestDivisor(int[] arr, int threshold) {
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int low = 1;
        int high = maxValue;
        int smallestDivisor = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(isSmallestDivisor(arr, mid, threshold)) {
                smallestDivisor = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return smallestDivisor;
        //return low;
    }

    private static boolean isSmallestDivisor(int[] arr, int mid, int threshold) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += (int)Math.ceil((double)arr[i]/mid);
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}
