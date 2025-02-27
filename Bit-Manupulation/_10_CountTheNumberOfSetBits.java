/*

*/
import java.util.Scanner;

public class _10_CountTheNumberOfSetBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("No Of Set Bits are : " + countSetBits(n));
        in.close();
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
