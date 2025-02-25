/*
Input Format: N = 6
Result:   
A B C D E F
A B C D E 
A B C D
A B C
A B
A
*/

import java.util.Scanner;

public class Pattern_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);

        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(char ch='A'; ch<='A'+n-i; ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
