/*
Input Format: N = 6
Result:   
A 
B B
C C C
D D D D
E E E E E
F F F F F F
*/

import java.util.Scanner;

public class Pattern_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        in.close();
    }

    private static void PrintPattern(int n) {
        for(char ch='A'; ch<='A'+n-1; ch++) {
            for(int j=1; j<=ch-'A'+1; j++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
