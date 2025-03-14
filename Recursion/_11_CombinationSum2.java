import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _11_CombinationSum2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int target = in. nextInt();
        Arrays.sort(arr);
        combinationSum2(0, target, new ArrayList<>(), arr, n);
        in.close();
    }

    private static void combinationSum2(int idx, int target, List<Integer> list, int[] arr, int n) {
        if(target == 0) {
            System.out.println(list);
            return;
        }
        for(int i=idx; i<n; i++) {
            if(i>idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            list.add(arr[i]);
            combinationSum2(i+1, target - arr[i], list, arr, n);
            list.remove(list.size()-1);
            
            
        }
    }
}
