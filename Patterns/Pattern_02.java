/*
Input Format: N = 6
Result:
* 
* * 
* * *
* * * *
* * * * *
* * * * * * 
*/

import java.util.Scanner;

public class Pattern_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        
        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("* ");
            }
            System.err.println();
        }
    }
}
