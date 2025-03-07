/*
LeetCode- 1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
*/
import java.util.Scanner;

public class _11_CountNoOfniceSubarray {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(getNoOfNiceSubarrays(arr, k) - getNoOfNiceSubarrays(arr, k-1));
        in.close();
    }

    private static int getNoOfNiceSubarrays(int[] arr, int k) {
        if(k<0) return 0;
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int NoOfNiceSubarray = 0;
        while(right < n) {
            sum += arr[right]%2;
            while(sum > k) {
                sum -= arr[left]%2;
                left++;
            }
            if(sum <= k) {
                NoOfNiceSubarray += (right - left + 1);
            }
            right++;
        }
        return NoOfNiceSubarray;
    }
}
