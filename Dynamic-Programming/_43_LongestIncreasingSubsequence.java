import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _43_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getLongestIncreasingSubsequence(n, arr));
    }
    // getting longest increasing subsequence using binary search
    private static int getLongestIncreasingSubsequence(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if(list.size() == 0 || list.get(list.size()-1) < arr[i]) {
                list.add(arr[i]);
            } else {
                int ind = getLowerBound(arr[i], list);
                list.set(ind, arr[i]);
            }
        }
        return list.size();
    }

    private static int getLowerBound(int x, List<Integer> list) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
