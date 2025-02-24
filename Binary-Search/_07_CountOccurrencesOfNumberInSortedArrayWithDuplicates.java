/*
Problem Statement : Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4
*/
import java.util.*;
public class _07_CountOccurrencesOfNumberInSortedArrayWithDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in.nextInt();
        System.out.println("Total Occurence Of Target : "+CountOccurrences(arr, n, target));

        in.close();
    }
    private static int CountOccurrences(int[] arr, int n, int target) {
        int first = getFirstPosition(arr, n, target);
        if (first != -1) {
            int last = getLastPosition(arr, n, target);
            return last - first + 1;
        }
        return 0;
    }

    private static int getFirstPosition(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int first = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int getLastPosition(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int last = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }
}
