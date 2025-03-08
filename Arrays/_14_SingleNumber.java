/*
LeetCode - 136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
*/

import java.util.Scanner;

public class _14_SingleNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getSingleNumber(arr, n));
        in.close();
    }

    private static int getSingleNumber(int[] arr, int n) {
        int xor = 0;
        for(int i=0; i<n; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
