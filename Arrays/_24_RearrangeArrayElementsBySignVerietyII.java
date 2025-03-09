/*
There’s an array ‘A’ of size ‘N’ with positive and negative elements (not necessarily equal). Without altering the relative 
order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover 
elements should be placed at the very end in the same order as in array A.

Note: Start the array with positive elements.

Example 1:
Input:
arr[] = {1,2,-4,-5,3,4}, N = 6
Output:1 -4 2 -5 3 4
Explanation:
Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
Leftover positive elements are 3 and 4 which are then placed at the end of the array.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// UnEven No Of Positive and Negative ( Positive != Negative)
public class _24_RearrangeArrayElementsBySignVerietyII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        arr = rearrangeArrayElements(arr, n);
        System.out.println(Arrays.toString(arr));
        in.close();

    }

    private static int[] rearrangeArrayElements(int[] arr, int n) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                positives.add(arr[i]);
            }
            else {
                negatives.add(arr[i]);
            }
        }
        if(positives.size() == 0 || negatives.size() == 0) return arr;

        if(positives.size() < negatives.size()) {
            for(int i=0; i<positives.size(); i++) {
                answer[i * 2] = positives.get(i);
                answer[(i * 2) + 1] = negatives.get(i);
            }
            int index = positives.size() * 2;
            for(int i=positives.size(); i<negatives.size(); i++) {
                answer[index] = negatives.get(i);
                index++;
            } 
        }
        else {
            for(int i=0; i<negatives.size() ; i++) {
                answer[i * 2] = positives.get(i);
                answer[(i * 2) + 1] = negatives.get(i);
            }
            int index = negatives.size() * 2;
            for(int i=negatives.size(); i<positives.size(); i++) {
                answer[index] = positives.get(i);
                index++;
            }
        }

        return answer;
    }
}
