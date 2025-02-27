/*
LeetCode - 78
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _12_PowerSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        List<List<Integer>> answer = powerSet(arr, n);

        System.out.println(answer);
        in.close();
    }

    private static List<List<Integer>> powerSet(int[] arr, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        int number = 1 << n;
        for (int num=0; num<number; num++) {
            List<Integer> tempList = new ArrayList<>();
            for(int i=0; i<n; i++) {
                if( (num & (1 << i)) != 0) {
                    tempList.add(arr[i]);
                }
            }
            answer.add(tempList);
        }
        return answer;
    }
}
