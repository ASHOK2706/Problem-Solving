/*
LeetCode - 34
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].
*/

import java.util.*;
public class _06_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();

        System.out.println("First ans Last Index Of Target : "+ Arrays.toString(FindFirstAndLastPosition(arr, n, target)));

        in.close();
    }

    private static int[] FindFirstAndLastPosition(int[] arr, int n ,int target) {
        int first = getFirstPosition(arr, n, target);
        if(first != -1)
            return new int[]{first, getLastPosition(arr, n, target)};
        return new int[]{-1, -1};
    }

    private static int getFirstPosition(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int first = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int getLastPosition(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int last = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }
}
