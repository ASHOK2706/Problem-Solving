import java.util.Scanner;

public class _06_HouseRobber2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int p1 = 0;
        int p2 = 0;
        for (int i=0; i<n; i++) {
            if (i != 0) {
                temp1[p1++] = arr[i];
            }
            if (i != n-1) {
                temp2[p2++] = arr[i];
            }
        }

        System.out.println(max(getMaximumSum(n-1, temp1), getMaximumSum(n-1, temp2)));

    }


    //Space Optimization Solution from Maximum Sum Of Non-Adjacent Element
    private static int getMaximumSum(int n, int[] arr) {

        int prev1 = arr[0];
        int prev2 = 0;
        for (int i=1; i<n; i++) {
            int pick = arr[i] + prev2;
            int notPick = prev1;
            int curr = max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
