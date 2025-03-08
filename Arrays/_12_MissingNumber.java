/*
LeetCode - 268. Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing 
from the array.
 
Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since 
it does not appear in nums.
*/

import java.util.Scanner;

public class _12_MissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getMissingNumber(arr, n));
        in.close();
    }

    private static int getMissingNumber(int[] arr, int n) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        int total = n * (n + 1) / 2;
        return total - sum;
    }
}
