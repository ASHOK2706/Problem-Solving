import java.util.Scanner;
import java.util.Arrays;

public class _04_ReverseArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
        in.close();
    }

    private static void reverse(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        swap(arr, left, right);
        left++;
        right--;
        reverse(arr, left, right);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
