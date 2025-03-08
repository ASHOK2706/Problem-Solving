/*
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where 
the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
Examples:
Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest 
subarray with a sum of 15 is 6.

Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.

Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[]
*/

import java.util.HashMap;
import java.util.Scanner;

public class _16_LongestSubarrayWithSumK { // Positive + Negative
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();;
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(getLongestSubarray(arr, n, k));
        in.close();
    }

    private static int getLongestSubarray(int[] arr, int n , int k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long prefixSum = 0;
        int length = 0;
        int maxLength = 0;
        for(int i=0; i<n ;i++) {
            prefixSum += arr[i];
            if(prefixSum == k) {
                maxLength = max(maxLength, i+1);
            }
            long remaining = prefixSum - k;

            if(preSumMap.containsKey(remaining)) {
                length = i - preSumMap.get(remaining);
                maxLength = max(maxLength, length);
            }

            if(!preSumMap.containsKey(prefixSum)) {
                preSumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}
