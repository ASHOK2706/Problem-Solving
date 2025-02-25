/*
Input Format: N = 6
Result:   
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
*/

import java.util.Scanner;

public class Pattern_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);

        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(j);
            }
            for(int k=1; k<=(n*2)-(i*2); k++) {
                System.out.print(" ");
            }
            for(int j=i; j>=1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
