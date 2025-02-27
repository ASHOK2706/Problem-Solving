/*

*/
import java.util.Scanner;

public class _08_RemoveRightMostSetBit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(removeRightMostSet(n));
        in.close();
    }

    private static int removeRightMostSet(int n) {
        return n & n - 1;
    }
}
