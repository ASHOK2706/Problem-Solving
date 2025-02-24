/*
LeetCode - 162
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, 
return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly 
greater than a neighbor that is outside the array.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/
import java.util.Scanner;

public class _13_FindPeekElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Peek Element is : "+FindPeekElement(arr, n));

        in.close();
    }

    private static int FindPeekElement(int[] arr, int n) {
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-1]) return n-1;
        int low = 1;
        int high = n-2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if (arr[mid-1] < arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
