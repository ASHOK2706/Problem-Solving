/*
LeetCode - 136
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
*/

import java.util.Scanner;

public class _13_SingleNumberI {
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
