/*
Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.
Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken 
then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class _12_SusetSum1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        getSubsetSum(0, 0, list, arr, n);
        list.sort(null);
        System.out.println(list);
        in.close();
    }

    private static void getSubsetSum(int index, int sum, List<Integer> list, int[] arr, int n) {
        if(index == n) {
            list.add(sum);
            return;
        }
        getSubsetSum(index + 1, sum + arr[index], list, arr, n);
        getSubsetSum(index + 1, sum, list, arr, n);
    }
}
