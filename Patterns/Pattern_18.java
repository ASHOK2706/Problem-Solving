/*
Input Format: N = 6
Result:   
F
E F
D E F
C D E F
B C D E F
A B C D E F
*/

import java.util.Scanner;

public class Pattern_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(char ch=(char)('A'+(n-i)); ch<='A'+n-1; ch++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
