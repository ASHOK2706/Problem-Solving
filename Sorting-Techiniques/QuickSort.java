
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, n-1);

        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        in.close();
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = findPartitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int findPartitionIndex(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low; 
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;    
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
