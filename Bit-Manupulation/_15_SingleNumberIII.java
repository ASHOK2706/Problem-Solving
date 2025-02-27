/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
*/

import java.util.Arrays;
import java.util.Scanner;

public class _15_SingleNumberIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int[] answer = fingSingleNumberIII(arr, n);
        System.out.println(Arrays.toString(answer));
        in.close();
    }

    private static int[] fingSingleNumberIII(int[] arr, int n) {
        int xor = 0;
        for(int num:arr) {
            xor = xor ^ num;
        }

        int rightMostSet = (xor & (xor - 1)) ^ xor;
        int bucket1 = 0;
        int bucket2 = 0;
        for(int num : arr) {
            if( (num & rightMostSet) != 0) {
                bucket1 = bucket1 ^ num;
            }
            else {
                bucket2 = bucket2 ^ num;
            }
        }

        return new int[] {bucket1, bucket2};
    }
}

