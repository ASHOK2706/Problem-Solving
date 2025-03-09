/*
LeetCode - 75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are 
adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
*/
import java.util.Arrays;
import java.util.Scanner;

public class _18_SortArrayOf012s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr, n);
        System.out.println(Arrays.toString(arr));

        in.close();
    }

    // Dutch National Flag Algorithm

    private static void sort(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /* 
    private static void sort(int[] arr, int n) {
        int zeros = 0;
        int ones = 0; 
        for(int i=0; i<n; i++) {
            if (arr[i] == 0) zeros++;
            else if (arr[i] == 1) ones++;
        }

        for(int i=0; i<zeros; i++) {
            arr[i] = 0;
        }
        for(int i=zeros; i<zeros+ones; i++) {
            arr[i] = 1;
        }
        for(int i=zeros+ones; i<n; i++) {
            arr[i] = 2;
        }
    }
    */
}
