/*
You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element is considered 
a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

Examples:
Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
*/


import java.util.ArrayList;
import java.util.Scanner;

public class _26_LeardersInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        printLearders(arr, n);
        in.close();
    }

    private static void printLearders(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> learders = new ArrayList<>();
        for(int i=n-1; i>=0; i--) {
            if(arr[i] > max) {
                max = arr[i];
                learders.add(max);
            }
        }
        reverse(learders, 0, learders.size()-1);
        System.out.println(learders);
        
    }

    private static void reverse(ArrayList<Integer> list, int i, int j) {
        while(i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
}
