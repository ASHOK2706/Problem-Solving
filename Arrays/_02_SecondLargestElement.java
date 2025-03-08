/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element 
doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.
*/
import java.util.Scanner;

public class _02_SecondLargestElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getSecondLargest(arr));
        in.close();
    }

    private static int getSecondLargest(int[] arr) {
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > maximum) {
                secondMaximum = maximum;
                maximum = arr[i];
            }
            else if(arr[i] != maximum && arr[i] > secondMaximum) {
                secondMaximum = arr[i];
            }
        }
        return secondMaximum;
    }
}
