import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_PrintAllSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        printSubsequences(0, list, arr, n);
        in.close();
    }

    private static void printSubsequences(int i, List<Integer> list, int[] arr, int n) {
        if(i == n) {
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        printSubsequences(i + 1, list, arr, n);
        list.remove(list.size() - 1);
        printSubsequences(i + 1, list, arr, n);
    } 
}
