/*
Given a number n and a bit number k, check if the kth index bit of n is set or not. A bit is called set if it is 1.
The position of set bit '1' should be indexed starting with 0 from the LSB side in the binary representation of the number.
Note: Index is starting from 0. You just need to return true or false.
*/
import java.util.Scanner;

public class _04_CheckIthBitSetOrNot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt();
        System.out.println(isIthBitSet(n, i));
        in.close();
    }

    private static boolean isIthBitSet(int n, int i) {
        return ( n & (1 << i) ) != 0;
        // return ( (n >> i) & 1 ) != 0;
    }
}
