/*
Given an array arr[]. The task is to find the largest element and return it.
*/
import java.util.Scanner;

public class _01_LargestElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getLargestElement(arr));

        in.close();
    }

    private static int getLargestElement(int[] arr) {
        int maximumValue = Integer.MIN_VALUE;
        for(int i=0; i<arr.length ;i++) {
            if(arr[i] > maximumValue) {
                maximumValue = arr[i];
            }
        }
        return maximumValue;
    }
}