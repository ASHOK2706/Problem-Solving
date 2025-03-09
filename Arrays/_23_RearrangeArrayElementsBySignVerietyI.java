/*
LeetCode - 2149. Rearrange Array Elements by Sign
There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order 
of positive and negative elements, you must return an array of alternately positive and negative values.

Note: Start the array with positive elements.

Example :
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy 
one or more conditions. 
*/
import java.util.Scanner;
import java.util.Arrays;

// Even No Of Positive and Negative ( Positive == Negative)
public class _23_RearrangeArrayElementsBySignVerietyI { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        arr = rearrange(arr, n);
        System.out.println(Arrays.toString(arr));
        in.close();
    }

    private static int[] rearrange(int[] arr, int n) {
        int[] answer = new int[n];
        int positive = 0;
        int negative = 1;
        for(int i=0; i<n; i++) {
            if(arr[i] > 0) {
                answer[positive] = arr[i];
                positive += 2;
            }
            else {
                answer[negative] = arr[i];
                negative += 2;
            }
        }
        return answer;
    }
}
