/*
LeetCode - 90. Subsets II
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _13_SubsetSum2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();
        getSubsetSum2(0, new ArrayList<>(), arr, n, answer);
        System.out.println(answer);
        in.close();
    }

    private static void getSubsetSum2(int index, List<Integer> list, int[] arr, int n, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(list));
        for(int i=index; i<n; i++) {
            if(i>index && arr[i] == arr[i-1]) continue;

            list.add(arr[i]);
            getSubsetSum2(i+1, list, arr, n, answer);
            list.remove(list.size()-1);
        }
    }
}
