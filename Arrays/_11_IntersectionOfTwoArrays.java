/*
LeetCode - 349. Intersection of Two Arrays
Given two integer arrays arr1 and arr2, return an array of their intersection. Each element in the result must be unique 
and you may return the result in any order.

Example 1:
Input: arr1 = [1,2,2,1], arr2 = [2,2]
Output: [2]

Example 2:
Input: arr1 = [4,9,5], arr2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class _11_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<n ;i++) {
            arr2[i] = in.nextInt();
        }

        ArrayList<Integer> intersection = getIntersection(arr1, n, arr2, m);

        System.out.println(intersection);

        in.close();
    }

    private static ArrayList<Integer> getIntersection(int[] arr1, int n, int[] arr2, int m) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] hashMap = new int[1001];
        for(int i=0; i<n; i++) {
            hashMap[arr1[i]]++;
        }

        for(int i=0; i<m; i++) {
            if(hashMap[arr2[i]] > 0) {
                answer.add(arr2[i]);
                hashMap[arr2[i]] = 0;
            }
        }

        return answer;
    }
}
