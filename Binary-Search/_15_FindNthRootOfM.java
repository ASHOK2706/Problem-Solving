/*
You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then returns -1.
*/

import java.util.Scanner;

public class _15_FindNthRootOfM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(findNthRootOfM(n, m));
        in.close();
    }

    private static int findNthRootOfM(int n, int m) {
        int low = 0;
        int high = m;
        int answer = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int value = getNthRootValue(mid, n);
            if(value == m) {
                answer = mid;
                low = mid + 1;
            }
            else if(value < m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private static int getNthRootValue(int x, int n) {
        int ans = 1;
        while(n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            else {
                x = x * x;
                n = n / 2;
            }
        }
        return ans;
    }
}