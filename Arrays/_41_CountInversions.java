/*
Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Examples
Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class _41_CountInversions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(countInversions(arr, n));
        in.close();
    }

    private static int countInversions(int[] arr, int n) {
        return mergeSort(arr, 0 ,n-1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low == high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }
            else{
                count += (mid - left + 1);
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
            arr[i] = list.get(i-low);
        }
        return count;
    }


}
