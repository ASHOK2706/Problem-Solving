/*
Given an array, and an element num the task is to find if num is present in the given array or not. If present print the index 
of the element or print -1.
*/

import java.util.Scanner;

public class _09_LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int element  = in.nextInt();
        int index = getIndexOfElement(arr, n, element);
        if( index != -1) {
            System.out.println(element + " is Appear At Index : "+ index);
        }
        else {
            System.out.println(element + " is Not Exists");
        }

        in.close();
    }

    private static int getIndexOfElement(int[] arr, int n, int element) {
        for(int i=0; i<n; i++) {
            if(arr[i] == element)
                return i;
        }
        return -1;
    }
}
