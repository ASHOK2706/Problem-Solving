/*
LeetCode - 56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the 
non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _38_MergeOverlappingSubintervals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] intervals = new int[n][2];
        for(int i=0; i<n; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
        }

        System.out.println(mergeIntervals(intervals, n));
        in.close();
    }

    private static List<List<Integer>> mergeIntervals(int[][] intervals, int n) {
        List<List<Integer>> pairs = new ArrayList<>();
        sort(intervals, n);

        int x1 = intervals[0][0];
        int x2 = intervals[0][1];

        for(int i=1; i<n; i++) {
            int y1 = intervals[i][0];
            int y2 = intervals[i][1];
            if(x2 >= y1) {
                if(x2 <= y2) x2 = y2;
            }
            else {
                pairs.add(Arrays.asList(x1, x2));
                x1 = y1;
                x2 = y2;
            }
        }
        pairs.add(Arrays.asList(x1, x2));
        return pairs;
    }

    private static void sort(int[][] intervals, int n) {
        for(int i=n-1; i>=1; i--) {
            for(int j=0; j<i; j++) {
                if(intervals[j][0] > intervals[j+1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j+1];
                    intervals[j+1] = temp;
                }
            }
        }
    }
}
