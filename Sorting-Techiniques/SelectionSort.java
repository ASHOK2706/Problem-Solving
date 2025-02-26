
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        selectionSort(arr, n);
        in.close();
    }

    private static void selectionSort(int[] arr, int n) {
        for (int i=0; i<=n-2; i++) {
            int min = i;
            for(int j=i; j<=n-1; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}