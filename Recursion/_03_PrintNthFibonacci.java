import java.util.Scanner;

public class _03_PrintNthFibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getNthFibonacci(n));
        in.close();
    }

    private static int getNthFibonacci(int n) {
        if(n <= 1) return n;
        int last = getNthFibonacci(n - 1);
        int secondLast = getNthFibonacci(n - 2);
        return last + secondLast;
    }
}
