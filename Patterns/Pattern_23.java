
import java.util.Scanner;

public class Pattern_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printPattern(n);
        in.close();
    }

    private static void printPattern(int n) {
        int start = 1;
        for(int i=1; i<=n; i++) {
            int value = start;
            for(int j=1; j<=i; j++) {
                System.out.print(value+" ");
                value -= n-i+j;
            }
            System.out.println();
            start += n-i+1;
        }
    }
}
