/*
Given an array arr containing both positive and negative integers, the task is to compute the length of the largest 
subarray that has a sum of 0.

Examples:
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray is [0, -4, 3, 1, 0].
*/
import java.util.HashMap;
import java.util.Scanner;

public class _36_LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getLargestSubarray(arr, n));
        in.close();
    }

    private static int getLargestSubarray(int[] arr, int n) {
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == 0) {
                maxLength = max(maxLength, i+1);
            }
            else if(preSumMap.containsKey(sum)) {
                int length = i - preSumMap.get(sum);
                maxLength = max(maxLength, length);
            }
            else {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}
