import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _08_PrintOneSubsequenceWithSumK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        printOneSubsequence(0, list, 0, k, arr, n);
        in.close();
    }

    private static boolean printOneSubsequence(int i, List<Integer> list, int sum, int k, int[] arr, int n) {
        if(i == n) {
            if(sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[i]);
        sum += arr[i];
        if(printOneSubsequence(i+1, list, sum, k, arr, n) == true) {
            return true;
        }
        list.remove(list.size()-1);
        sum -= arr[i];

        return printOneSubsequence(i+1, list, sum, k, arr, n);
    }
}
