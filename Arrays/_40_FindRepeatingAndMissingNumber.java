/*
Given an unsorted array arr of positive integers. One number a from the set [1, 2,....,n] is missing and one number b occurs 
twice in the array. Find numbers a and b.
Note: The test cases are generated such that there always exists one missing and one repeating number within the range [1,n].

Examples:
Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and smallest positive missing number is 2.
Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.
*/

import java.util.Scanner;

public class _40_FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int[] ans = getRepeatingAndMissing(arr, n);
        System.out.println("Repeating Elemet : "+ ans[0]);
        System.out.println("Missing Element : "+ ans[1]);
        in.close();
    }

    private static int[] getRepeatingAndMissing(int[] arr, int n) {
        int sum1 = 0;
        int sum1N = 0;
        int sum2 = 0;
        int sum2N = 0;
        for(int i=0; i<n; i++) {
            sum1 += arr[i];
            sum2 += (arr[i] * arr[i]);
        }
        sum1N = (n * (n + 1)) / 2;
        sum2N =  (n * (n + 1) * (2 * n + 1))  / 6;

        int value1 = sum1 - sum1N;
        int value2 = sum2 - sum2N;
        value2 = value2 / value1;

        int repeatingElemet = (value1 + value2) / 2;
        int missingElement = repeatingElemet - value1;
        return new int[]{repeatingElemet, missingElement};
    }
}
