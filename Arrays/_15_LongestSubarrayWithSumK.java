/*
You are given an array 'a' of size 'n' and an integer 'k'. 
Find the length of the longest subarray of 'a' whose sum is equal to 'k'.

Example :
Input: ‘n’ = 7 ‘k’ = 3
‘a’ = [1, 2, 3, 1, 1, 1, 1]
Output: 3
Explanation: Subarrays whose sum = ‘3’ are:
[1, 2], [3], [1, 1, 1] and [1, 1, 1]
Here, the length of the longest subarray is 3, which is our final answer.
*/
import java.util.Scanner;

public class _15_LongestSubarrayWithSumK { // Positive
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(getLongestSubarray(arr, n, k));
        in.close();
    }
    // Two  Pinter / Sliding Window  
    private static int getLongestSubarray(int[] arr, int n , int k) {
        int left = 0;
        int right = 0;
        int length = 0;
        int maxLength = 0;
        long sum = 0;
        while(right < n) {
            sum += arr[right];
            while(sum > k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k) {
                length = right - left + 1;
                maxLength = max(maxLength, length);
            }
            right++;
        }
        return maxLength;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    /*
    // Prefix Sum
    private static int getLongestSubarray(int[] arr, int n , int k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long prefixSum = 0;
        int length = 0;
        int maxLength = 0;
        for(int i=0; i<n ;i++) {
            prefixSum += arr[i];
            if(prefixSum == k) {
                maxLength = max(maxLength, i+1);
            }
            long remaining = prefixSum - k;

            if(preSumMap.containsKey(remaining)) {
                length = i - preSumMap.get(remaining);
                maxLength = max(maxLength, length);
            }

            if(!preSumMap.containsKey(prefixSum)) {
                preSumMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }
    */

}
