/*

*/
import java.util.Scanner;

public class _07_ToogleIthBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = in.nextInt();
        System.out.println(toggleIthBit(n, i));
        in.close();
    }

    private static int toggleIthBit(int n, int i) {
        return n ^ (1 << i);
    }
}
