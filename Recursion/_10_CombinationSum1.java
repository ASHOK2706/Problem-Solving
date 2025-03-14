import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _10_CombinationSum1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]  = in.nextInt();
        }
        int target = in.nextInt();
        List<Integer> list = new ArrayList<>();
        combinationSum1(0, target, list, arr, n);
        in.close();
    }

    private static void combinationSum1(int idx, int target, List<Integer> list, int[] arr, int n) {
        if(idx == n) {
            if(target == 0) {
                System.out.println(list);
            }
            return;
        }

        if(arr[idx] <= target) {
            list.add(arr[idx]);
            combinationSum1(idx, target - arr[idx], list, arr, n);
            list.remove(list.size()-1);
        }
        combinationSum1(idx + 1, target, list, arr, n);
    }
}
