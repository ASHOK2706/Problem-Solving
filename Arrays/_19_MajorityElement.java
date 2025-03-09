/*
LeetCode - 169. Majority Element 
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority 
element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

// import java.util.HashMap;
// import java.util.Map;
import java.util.Scanner;

public class _19_MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(getMajorityElement(arr, n));
        in.close();
    }

    //Boyer-Moore Majority Voting Algorithm
    private static int getMajorityElement(int[] arr, int n) {
        int element = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(count == 0) {
                element = arr[i];
                count = 1;
            }
            else if(element == arr[i]) {
                count++;
            }
            else {
                count--;
            }
        }
        count = 0;
        for(int i=0; i<n; i++) {
            if(element == arr[i]) count++;
        }
        if(count > (n/2)) return element;
        return - 1;
    }


    /* 
    private static int getMajorityElement(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()) {
            if(it.getValue() > (n/2)) {
                return it.getKey();
            }
        }
        return -1;
    }
    */
}
