/*
leetCode - 930. Binary Subarrays With Sum
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15
*/

import java.util.Scanner;

public class _10_BinarySubarrayWithSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int goal = in.nextInt();
        System.out.println(getBinarySum(arr, goal) - getBinarySum(arr, goal-1));
        in.close();
    }

    private static int getBinarySum(int[] arr, int goal) {
        if(goal < 0) return 0;
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxNoOfSubarray = 0;
        while (right < n) {
            sum += arr[right];
            while(sum > goal) {
                sum -= arr[left];
                left++;
            }
            maxNoOfSubarray += (right - left + 1);
            right++;
        }
        return maxNoOfSubarray;
    }
}
