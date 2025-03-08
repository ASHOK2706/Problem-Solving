/*
LeetCode - 485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2
*/
import java.util.Scanner;

public class _13_MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(findMaxConsecutiveOnes(arr, n));
        in.close();
    }

    private static int findMaxConsecutiveOnes(int[] arr, int n) {
        int ones = 0;
        int maxOnes = 0;
        for(int i=0; i<n; i++) {
            ones += arr[i];
            if(arr[i] == 0) ones = 0;
            if(ones > maxOnes) {
                maxOnes = ones;
            }
        }
        return maxOnes;
    }
}
