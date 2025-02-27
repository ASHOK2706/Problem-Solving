/*

*/
import java.util.Scanner;

public class _06_ClearIthBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt();
        System.out.println(clearIthBit(n, i));
        in.close();
    }

    private static int clearIthBit(int n, int i) {
        return n & (~(1 << i));
    }
}
