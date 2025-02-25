/*
Input Format: N = 6
Result:   
6 6 6 6 6 6 6 6 6 6 6 
6 5 5 5 5 5 5 5 5 5 6 
6 5 4 4 4 4 4 4 4 5 6 
6 5 4 3 3 3 3 3 4 5 6 
6 5 4 3 2 2 2 3 4 5 6 
6 5 4 3 2 1 2 3 4 5 6 
6 5 4 3 2 2 2 3 4 5 6 
6 5 4 3 3 3 3 3 4 5 6 
6 5 4 4 4 4 4 4 4 5 6 
6 5 5 5 5 5 5 5 5 5 6 
6 6 6 6 6 6 6 6 6 6 6
*/

import java.util.Scanner;

public class Pattern_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PrintPattern(n);
        in.close();
    }

    private static void PrintPattern(int n) {
        int m = n;
        m = m * 2 - 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                int a = min(i, j);
                int b = min(m-1-i, m-1-j);
                System.out.print(n - min(a, b) +" ");
            }
            System.out.println();
        }
    }

    private static int min(int x, int y) {
        return (x < y) ? x : y;
    }
}
