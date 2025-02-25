/*
Input Format: N = 6
Result:
* * * * * *
* * * * * 
* * * * 
* * * 
* * 
* 
*/

import java.util.Scanner;

public class Pattern_05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);

        in.close();
    }

    private static void PrintPattern(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
