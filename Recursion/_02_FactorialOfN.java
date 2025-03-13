import java.util.Scanner;

public class _02_FactorialOfN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getFactorial(n));
        in.close();
    }

    private static int getFactorial(int n) {
        if(n == 0) return 1;
        return n * getFactorial(n - 1);
    }
}
