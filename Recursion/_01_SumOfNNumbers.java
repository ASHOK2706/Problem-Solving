import java.util.Scanner;

public class _01_SumOfNNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getSum(n));
        in.close();
    }

    private static int getSum(int n) {
        if(n == 0) {
            return 0;
        }
        return n + getSum(n - 1);
    }
}