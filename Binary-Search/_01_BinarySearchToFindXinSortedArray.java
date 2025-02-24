/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target 
in nums. If target exists, then return its index. Otherwise, return -1.
*/

import java.util.Scanner;
public class _01_BinarySearchToFindXinSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(BinarySearchToFindX(arr, target));
        in.close();
    }

    private static int BinarySearchToFindX(int[] arr, int target) {
        return -1;
    }
}
