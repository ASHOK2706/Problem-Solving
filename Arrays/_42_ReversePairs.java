/*
LeetCode - 493. Reverse Pair
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
*/

import java.util.ArrayList;
import java.util.Scanner;

public class _42_ReversePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(countReversePairs(arr, n));
        in.close();
    }

    private static int countReversePairs(int[] arr , int n) {
        return mergeSort(arr, 0 ,n-1);
    }
 
    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low == high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countOfReversePairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right<=high) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }
            else {
                list.add(arr[right]);
                right++;
            }
        }
        while(left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while(right <= high) {
            list.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++) {
            arr[i] = list.get(i - low);
        }
    }

    private static int countOfReversePairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for(int i=low; i<=mid; i++) {
            while(right <= high && arr[i] > (long)2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
}
