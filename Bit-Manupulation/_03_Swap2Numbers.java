/*

*/
import java.util.Scanner;

public class _03_Swap2Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        System.out.println("Before Swapping : "+ num1 + "  "+ num2);
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
        System.out.println("Before Swapping : "+ num1 + "  "+ num2);
        in.close();
    }

    // private static void swap(int a, int b) {
    //     a = a ^ b;
    //     b = a ^ b;
    //     a = a ^ b;
    // }
}