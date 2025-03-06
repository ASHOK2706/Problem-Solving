/*
LeetCode - 1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
*/
import java.util.Scanner;

public class _05_MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(findMaxLengthOfOnes(arr, k));
        in.close();
    }

    private static int findMaxLengthOfOnes(int[] arr, int k) {
        int n = arr.length;
        int zeros = 0;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int length = 0;
        while(right < n) {
            if(arr[right] == 0) zeros++;
            while(zeros > k) { // if () {} 
                if(arr[left] == 0) zeros--;
                left++;
            }
            if(zeros <= k) {
                length = right - left + 1;
                if(length > maxLength) {
                    maxLength = length;
                }
            }
            right++;
        }
        return maxLength;
    }
}


