/*
Input Format: N = 6
Result:   
1
01
101
0101
10101
010101
*/

import java.util.Scanner;

public class Pattern_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);

        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            int value = i%2;
            for(int j=1; j<=i; j++) {
                System.out.print(value);
                value = 1 - value;
            }
            System.out.println();
        }
    }
}
