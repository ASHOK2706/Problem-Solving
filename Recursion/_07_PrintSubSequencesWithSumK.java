import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_PrintSubSequencesWithSumK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        printSubsequences(0, list, 0, arr, n, k);
        in.close();
    }

    private static void printSubsequences(int i, List<Integer> list, int sum, int[] arr, int n, int k) {
        if(i == n) {
            if(sum == k) {
                System.out.println(list);
            }
            return;
        }
        list.add(arr[i]);
        printSubsequences(i + 1, list, sum + arr[i], arr, n, k);
        list.remove(list.size() - 1);
        printSubsequences(i + 1, list, sum, arr, n, k);
    }
}
