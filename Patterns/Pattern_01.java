/*
Input: N = 6
Output:
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
*/
import java.util.Scanner;

public class Pattern_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);

        in.close();
    }

    private static void PrintPattern(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}