/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

import java.util.Arrays;
// import java.util.HashSet;
import java.util.Scanner;

public class _27_LongestConsecutiveSequenceInArray {
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getLongestConsecutiveSequence(arr, n));
        in.close();
    }
    // Approach - 1
    private static int getLongestConsecutiveSequence(int[] arr, int n) {
        int count = 0;
        int length = 1;
        int lastMinimum = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            if(arr[i] - 1 == lastMinimum) {
                count = count + 1;
                lastMinimum = arr[i];
            }
            else if(arr[i] != lastMinimum) {
                lastMinimum = arr[i];
                count = 1;
            }
            if(count > length) {
                length = count;
            }
        }
        return length;
    }


    /* 
    // Approach - 2
    private static int getLongestConsecutiveSequence(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            set.add(arr[i]);
        }
        int length = 0;
        for(int num : set) {
            int count = 0;
            if(!set.contains(num-1)) {
                int x = num;
                while (set.contains(x)) {
                    x = x + 1;
                    count = count + 1;
                }
                if(count > length) {
                    length = count;
                }
            }
        }

        return length;
    }
    */
}
