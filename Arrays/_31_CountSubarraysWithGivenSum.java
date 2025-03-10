/*
LeetCode - 560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2
Input: nums = [1,2,3], k = 3
Output: 2
*/
import java.util.HashMap;
import java.util.Scanner;

public class _31_CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(countSubarray(arr, n, k));
        in.close();
    }

    private static int countSubarray(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        map.put(prefixSum, 1);
        for(int i=0; i<n; i++) {
            prefixSum = prefixSum + arr[i];
            int rem = prefixSum - k;
            count += map.getOrDefault(rem, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 1));
        }
        return count;
    }
}
