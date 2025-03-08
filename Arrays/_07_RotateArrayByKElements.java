import java.util.Scanner;

public class _07_RotateArrayByKElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();

        k = k % n;

        reverseArray(arr, 0, (n-k)-1);
        reverseArray(arr, n-k, n-1);
        reverseArray(arr, 0, n-1);

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }

        in.close();
    }

    private static void reverseArray(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
