/*
LeetCode - 35
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

*/
import java.util.*;
public class _04_SearchInsertPosition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int x = in.nextInt();

        System.out.println("Insert Position is : "+SearchInsertPosition(arr, x));
        in.close();
    }
    private static int SearchInsertPosition(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int position = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= x) {
                position = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return position;
    }
}
