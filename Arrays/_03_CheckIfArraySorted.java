/*
Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) 
order or not. If the array is sorted then return True, Else return False.
*/
import java.util.Scanner;

public class _03_CheckIfArraySorted {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(isSorted(arr, n));
        in.close();
    }
    private static boolean isSorted(int[] arr, int n) {
        for(int i=1; i<n; i++) {
            if(arr[i-1] > arr[i])
                return false;
        }
        return true;
    }
}
