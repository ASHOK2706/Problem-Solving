import java.util.Arrays;
import java.util.Scanner;

public class _15_Permuntation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        generatePermuntation(0, arr, n);
        in.close();
    }

    private static void generatePermuntation(int index, int[] arr, int n) {
        if(index == n) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i=index; i<n; i++) {
            swap(arr, index, i);
            generatePermuntation(index+1, arr, n);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
