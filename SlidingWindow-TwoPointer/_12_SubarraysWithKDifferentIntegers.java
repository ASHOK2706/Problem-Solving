/*
LeetCode - 992. Subarrays with K Different Integers
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Example 2:
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
*/
import java.util.Scanner;
import java.util.HashMap;

public class _12_SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(subarraysWithKDistinct(arr, k) - subarraysWithKDistinct(arr, k-1));
        in.close();
    }

    private static int subarraysWithKDistinct(int[] arr, int k) {
        if(k < 0) return 0;
        int n = arr.length;
        int left = 0;
        int right = 0;
        int NoOfSubarray = 0;
        HashMap<Integer, Integer> distinctIntegers = new HashMap<>();
        while(right < n) {
            distinctIntegers.put(arr[right], distinctIntegers.getOrDefault(arr[right], 0)+1);
            while(distinctIntegers.size() > k) {
                distinctIntegers.put(arr[left], distinctIntegers.get(arr[left]) - 1);
                if(distinctIntegers.get(arr[left]) == 0) {
                    distinctIntegers.remove(arr[left]);
                }
                left++;
            }
            NoOfSubarray += (right - left + 1);
            right++;
        }
        return NoOfSubarray;
    }
}
