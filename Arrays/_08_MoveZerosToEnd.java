import java.util.Scanner;

public class _08_MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++) {
            arr[i] = in.nextInt();
        }

        moveZeros(arr, n);

        for(int i=0; i<n ;i++) {
            System.out.print(arr[i] + " ");
        }

        in.close();
    }

    private static void moveZeros(int[] arr, int n) {
        int k = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                arr[k] = arr[i];
                if(i != k) {
                    arr[i] = 0;
                }
                k++;
            }
        }
    }
}
