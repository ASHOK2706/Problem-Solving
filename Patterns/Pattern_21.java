/*
Input Format: N = 6
Result:   
******
*    *
*    *
*    *
*    *
******
*/

import java.util.Scanner;

public class Pattern_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1 || j==1 || i==n || j==n) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}