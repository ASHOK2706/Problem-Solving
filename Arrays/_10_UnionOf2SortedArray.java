/*
Given two sorted arrays a[] and b[], where each array may contain duplicate elements , the task is to return the 
elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.
Examples:
Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
*/
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _10_UnionOf2SortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n ;i++) {
            arr1[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++) {
            arr2[i] = in.nextInt();
        }

        List<Integer> union = getUnion(arr1, n, arr2, m);
        System.out.println(union);
        in.close();
    }

    private static List<Integer> getUnion(int[] arr1, int n, int[] arr2, int m) {
        int left = 0;
        int right = 0;
        List<Integer> answer = new ArrayList<>();
        while(left < n && right < m) {
            if(arr1[left] < arr2[right]) {
                if(answer.size() == 0 || answer.get(answer.size()-1) != arr1[left]) {
                    answer.add(arr1[left]);
                }
                left++;
            }
            else if(arr2[right] < arr1[left]) {
                if(answer.size() == 0 || answer.get(answer.size()-1) != arr2[right]) {
                    answer.add(arr2[right]);
                }
                right++;
            }
            else {
                if(answer.size() == 0 || answer.get(answer.size()-1) != arr1[left]) {
                    answer.add(arr1[left]);
                }
                left++;
                right++;
            }
        }

        while(left < n) {
            if(answer.size() == 0 || answer.get(answer.size()-1) != arr1[left]) {
                answer.add(arr1[left]);
            }
            left++;
        }

        while(right < m) {
            if(answer.size() == 0 || answer.get(answer.size()-1) != arr2[right]) {
                answer.add(arr2[right]);
            }
            right++;
        }

        return answer;
    }
}
