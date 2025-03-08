/*
Given an array 'arr' containing 'n' elements, rotate this array left once and return it.

Rotating the array left by one means shifting all elements by one place to the left and moving the first element to the 
last position in the array. 
Example : 
Input: 'a' = 5, 'arr' = [1, 2, 3, 4, 5]
Output: [2, 3, 4, 5, 1]
Explanation:    We moved the 2nd element to the 1st position, and 3rd element to the 2nd position, and 4th element to 
                the 3rd position, and the 5th element to the 4th position, and move the 1st element to the 5th position.
*/
import java.util.Arrays;
import java.util.Scanner;

public class _06_LeftRotateArrayByOnePlace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        doLeftRotateByOnePlace(arr, n);

        System.out.println(Arrays.toString(arr));
        in.close();
    }

    private static void doLeftRotateByOnePlace(int[] arr, int n) {
        int temp = arr[0];
        for(int i=1; i<n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
}
