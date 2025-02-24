/*
LeetCode - 540
You are given a sorted array consisting of only integers where every element appears exactly twice, 
except for one element which appears exactly once.

Return the single element that appears only once.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/

import java.util.Scanner;
public class _12_SingleElementInSortedArray {
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int  i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(FindSingleElement(arr, n));

        in.close();
    }

    private static int FindSingleElement(int[] arr, int n) {
        if (n==1) return arr[0];
        else if (arr[0] != arr[1]) return arr[0];
        else if (arr[n-1] != arr[n-2]) return arr[n-1];
        int low = 1;
        int high = n - 2;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
                return arr[mid];
            }
            else if ( (mid % 2 == 0 && arr[mid] == arr[mid+1]) || ( mid % 2 != 0 && arr[mid] == arr[mid-1]) ) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
