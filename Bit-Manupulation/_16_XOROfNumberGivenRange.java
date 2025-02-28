/*
You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].
Input: L = 4, R = 8 
Output: 8 
Explanation: 4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
*/

import java.util.Scanner;

public class _16_XOROfNumberGivenRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int R = in.nextInt();
        System.out.println(getXOR(L - 1) ^ getXOR(R));
        in.close();
    }

    private static int getXOR(int n) {
        if (n % 4 == 0) return n;
        else if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n+1;
        else return 0;
    }
}
