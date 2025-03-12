/*
LeetCode - 18. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _35_4Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println(fourSum(arr, n, target));
        in.close();
    }
    private static List<List<Integer>> fourSum(int[] arr, int n, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            if(i!=0 && arr[i] == arr[i-1]) continue;
            for(int j=i+1; j<n; j++) {
                if((i+1) != j && arr[j] == arr[j-1]) continue;

                int k = j + 1;
                int l = n - 1;

                while(k < l) {
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if(sum < target) {
                        k++;
                    }
                    else if(sum > target) {
                        l--;
                    }
                    else {
                        List<Integer> tempList = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        fourSumList.add(tempList);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]) k++;
                        while(k < l && arr[l] == arr[l+1]) l--;
                    }
                }
            }
        }
        return fourSumList;
    }
}
