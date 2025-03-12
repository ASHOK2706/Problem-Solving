/*
Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. 
Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:
Input:
n = 4, arr1[] = [1 4 8 10] 
m = 5, arr2[] = [2 3 9]
Output:
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]
*/

import java.util.Arrays;
import java.util.Scanner;

public class _39_MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) {
            arr2[i] = in.nextInt();
        }
        merge(arr1, n, arr2, m);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        in.close();
    }
    private static void merge(int[] arr1, int n, int[] arr2, int m) {
        int length = n + m;
        int gap = (length / 2) + (length % 2);
        while(gap > 0) {
            int left = 0;
            int right = gap;
            while(right < length) {
                if(left < n  && right >=n) { // arr1 , arr2
                    swap(arr1, arr2, left, right - n);
                }
                else if(left >= n) { // arr2 , arr2
                    swap(arr2, arr2, left - n, right - n);
                }
                else {
                    swap(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swap(int[] arr1, int[] arr2, int ind1, int ind2) {
        if(arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    /*
    private static void merge(int[] arr1, int n, int[] arr2, int m) {
        int left = n - 1;
        int right = 0;
        while(left >= 0 && right < m) {
            if(arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }
            else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
     */

}
