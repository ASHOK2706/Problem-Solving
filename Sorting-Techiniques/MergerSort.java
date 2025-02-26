
import java.util.Scanner;
import java.util.ArrayList;

public class MergerSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        mergerSort(arr, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        in.close();
    }

    private static void mergerSort(int[] arr, int low, int high) {
        if(low == high) return;
        int mid = (low + high) / 2;
        mergerSort(arr, low, mid);
        mergerSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left++]);
            }
            else {
                list.add(arr[right++]);
            }   
        }
        while (left <= mid) {
            list.add(arr[left++]);
        }
        while (right <= high) {
            list.add(arr[right++]);
        }

        for (int i=low; i<=high; i++) {
            arr[i] = list.get(i-low);
        }
    }
}
