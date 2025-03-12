/*
LeetCode - 229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _33_MajorityElementII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> answer = majorityElement(arr, n);
        System.out.println(answer);
        in.close();
    }

    private static List<Integer> majorityElement(int[] arr, int n) {
        List<Integer> answer = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int element1 = 0;
        int element2 = 0;
        for(int i=0; i<n; i++) {
            if(count1 == 0 && element2 != arr[i]) {
                count1 = 1; 
                element1 = arr[i];
            }
            else if(count2 == 0 && element1 != arr[i]) {
                count2 = 1;
                element2 = arr[i];
            }
            else if(arr[i] == element1) {
                count1++;
            }
            else if(arr[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        int minFreq = (n / 3) + 1;
        for(int i=0; i<n; i++) {
            if(arr[i] == element1) count1 ++;
            else if(arr[i] == element2) count2++;
        }
        if(count1 >= minFreq) answer.add(element1);
        if(count2 >= minFreq) answer.add(element2);
        return answer;
    }
}
