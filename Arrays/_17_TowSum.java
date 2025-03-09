/*
LeetCode - 1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class _17_TowSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        int[] answer  = twoSum(arr, target);
        System.out.println(Arrays.toString(answer));
        in.close();
    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int rem = target - arr[i];
            if(map.containsKey(rem)) {
                return new int[] {map.get(rem), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
