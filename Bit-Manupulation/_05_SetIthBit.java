/*

*/
import java.util.Scanner;

public class _05_SetIthBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt();
        System.out.println(setIthBit(n, i));
        in.close();
    }

    private static int setIthBit(int n, int i) {
        return n | (1 << i);
    }
}
