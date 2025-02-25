/*
Input Format: N = 6
Result:   
     A     
    ABA    
   ABCBA   
  ABCDCBA  
 ABCDEDCBA 
ABCDEFEDCBA
*/

import java.util.Scanner;

public class Pattern_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        in.close();
    }

    private static void PrintPattern(int n) {
        for(int i=1; i<=n; i++) {
            for(int k=1; k<=n-i; k++) {
                System.out.print(" ");
            }
            char ch = 'A';
            for(int j=1; j<=i; j++) {
                System.out.print(ch++);
            }
            ch--;
            for(int j=1; j<i; j++) {
                System.out.print(--ch);
            }
            System.out.println();
        }
    }
}
